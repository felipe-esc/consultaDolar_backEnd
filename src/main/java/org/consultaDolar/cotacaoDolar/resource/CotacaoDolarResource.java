package org.consultaDolar.cotacaoDolar.resource;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/cotacaoDolarDia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Cotação Dólar", description = "Consultas de cotação de dólar.")
@AllArgsConstructor
@Slf4j
public class CotacaoDolarResource {

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Consulta cotação do dólar no dia indicado.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = CotacaoDolar.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Requisição de consulta realizada de forma incorreta.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "404",
            description = "Não foi possível encontrar nenhuma cotação de dólar.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "502",
            description = "Bad Gateway",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response consultaDolarDia(
            @Parameter(name = "dataCotacao", required = true)
            @RestQuery(value = "dataCriacao") String dataCotacao
    ) {
        return Response.ok(new CotacaoDolar()).build();
    }

}
