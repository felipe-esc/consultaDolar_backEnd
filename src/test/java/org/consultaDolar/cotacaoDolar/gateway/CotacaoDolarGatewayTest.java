package org.consultaDolar.cotacaoDolar.gateway;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.consultaDolar.cotacaoDolar.externalService.CotacaoDolarExternalService;
import org.consultaDolar.cotacaoDolar.externalService.response.CotacaoDolarResponse;
import org.consultaDolar.cotacaoDolar.service.CotacaoDolarService;
import org.jboss.resteasy.reactive.RestQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@QuarkusTest
class CotacaoDolarGatewayTest {

    @RestQuery
    @InjectMock
    private CotacaoDolarExternalService cotacaoDolarExternalServiceMock;

    @InjectMock
    private CotacaoDolarService cotacaoDolarServiceMock;

    @InjectMocks
    private CotacaoDolarGateway cotacaoDolarGateway;

    @BeforeEach
    public void setUp() {
        Uni<CotacaoDolarResponse> cotacaoDolarResponseUni = Uni
                .createFrom()
                .item(createCotacaoDolarResponse());

        when(cotacaoDolarExternalServiceMock.consultaDolarDia(anyString()))
                .thenReturn(cotacaoDolarResponseUni);
        doNothing().when(cotacaoDolarServiceMock).save(any(CotacaoDolar.class));
    }

    @Test
    public void testCotacaoDolarDia() {
        String dataCotacao = "MM-DD-YYYY";
        Uni<CotacaoDolar> result = cotacaoDolarGateway.consultaDolarDia(dataCotacao);

        UniAssertSubscriber<CotacaoDolar> uniAssertSubscriber = result
                .invoke(r -> assertThat(r.getDataCotacao(), is(dataCotacao)))
                .invoke(r -> assertThat(r.getRequestTimestamp(), isNotNull()))
                .invoke(() ->
                        verify(cotacaoDolarServiceMock, times(1)).save(any(CotacaoDolar.class))
                )
                .subscribe().withSubscriber(UniAssertSubscriber.create());

        uniAssertSubscriber.assertCompleted();
    }

    private CotacaoDolarResponse createCotacaoDolarResponse() {
        CotacaoDolarResponse cotacaoDolarResponse = new CotacaoDolarResponse();
        cotacaoDolarResponse.setContext("test");
        CotacaoDolar cotacaoDolar = new CotacaoDolar();
        cotacaoDolar.setCotacaoCompra(0.01);
        cotacaoDolar.setCotacaoVenda(0.02);
        cotacaoDolar.setDataHoraCotacao("MM-DD-YYYY HH:mm:ss:zzz");
        cotacaoDolarResponse.setValue(List.of(cotacaoDolar));
        return cotacaoDolarResponse;
    }
}