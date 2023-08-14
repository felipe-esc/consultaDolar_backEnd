package org.consultaDolar.cotacaoDolar.externalService.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;

import java.util.List;

@Data
public class CotacaoDolarResponse {

    @JsonProperty("@odata.context")
    private String context;

    private List<CotacaoDolar> value;
}
