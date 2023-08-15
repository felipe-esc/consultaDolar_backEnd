package org.consultaDolar.cotacaoDolar.gateway;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.UniSubscribe;
import io.smallrye.mutiny.subscription.UniDelegatingSubscriber;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.consultaDolar.cotacaoDolar.externalService.CotacaoDolarExternalService;
import org.consultaDolar.cotacaoDolar.service.CotacaoDolarService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@ApplicationScoped
@Slf4j
public class CotacaoDolarGateway {

    @RestClient
    private CotacaoDolarExternalService cotacaoDolarExternalService;

    @Inject
    private CotacaoDolarService cotacaoDolarService;

    @Transactional
    public Uni<CotacaoDolar> consultaDolarDia(String dataCotacao) {
        Timestamp reqTimestamp = new Timestamp(Instant.now().toEpochMilli());

        return cotacaoDolarExternalService.consultaDolarDia(dataCotacao)
                .onFailure().retry().atMost(3)
                .map(
                        (res) -> res.getValue()
                                .stream().findFirst()
                                .orElseThrow(NotFoundException::new)

                )
                .emitOn(Executors.newSingleThreadExecutor())
                .invoke(
                        (res) -> {
                            res.setDataCotacao(dataCotacao);
                            res.setRequestTimestamp(reqTimestamp);
                            cotacaoDolarService.save(res);
                        }
                );
    }

}
