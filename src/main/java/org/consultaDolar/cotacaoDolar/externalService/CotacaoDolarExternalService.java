package org.consultaDolar.cotacaoDolar.externalService;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.consultaDolar.cotacaoDolar.externalService.response.CotacaoDolarResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "bc-api")
@ClientQueryParam(name = "$format", value = "json")
public interface CotacaoDolarExternalService {

    @GET
    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    public Uni<CotacaoDolarResponse> consultaDolarDia(@QueryParam("@dataCotacao") String dataCotacao);
}

