package org.consultaDolar.cotacaoDolar.resource;

import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import io.smallrye.mutiny.Uni;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.consultaDolar.cotacaoDolar.gateway.CotacaoDolarGateway;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(CotacaoDolarResource.class)
class CotacaoDolarResourceTest {

    @InjectMock
    private CotacaoDolarGateway cotacaoDolarGatewayMock;

    @Test
    public void testCotacaoDolarDia() {
        CotacaoDolar createdCotacaoDolar = createCotacaoDolar();
        when(cotacaoDolarGatewayMock.consultaDolarDia(any()))
                .thenReturn(Uni.createFrom().item(createCotacaoDolar()));

        Response result = given()
                .when()
                .get("/cotacaoDolarDia?dataCotacao='MM-DD-YYYY'")
                .then()
                .statusCode(200)
                .extract().response();

        CotacaoDolar body = result.body().as(CotacaoDolar.class);

        assertThat(body.getRequestTimestamp(), is(createdCotacaoDolar.getRequestTimestamp()));
    }


    private CotacaoDolar createCotacaoDolar() {
        CotacaoDolar cotacaoDolar = new CotacaoDolar();
        cotacaoDolar.setDataHoraCotacao("");
        cotacaoDolar.setCotacaoVenda(1d);
        cotacaoDolar.setCotacaoVenda(1d);
        cotacaoDolar.setDataCotacao("");
        cotacaoDolar.setRequestTimestamp(new Timestamp(Instant.now().toEpochMilli()));
        cotacaoDolar.setRequestId(1);
        return cotacaoDolar;
    }
}