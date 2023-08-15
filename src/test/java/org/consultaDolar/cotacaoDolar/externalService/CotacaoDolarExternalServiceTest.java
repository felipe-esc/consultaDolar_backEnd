package org.consultaDolar.cotacaoDolar.externalService;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class CotacaoDolarExternalServiceTest {

    @Test
    public void testCotacaoDolarDia() {
        given()
                .when()
                .get("/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='08-14-2023'&$format=json")
                .then()
                .statusCode(200)
                .body(
                        "$.size()", is(1),
                        "[0].dataCotacao", is("'08-14-2023'")
                );
    }
}