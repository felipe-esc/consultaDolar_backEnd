package org.consultaDolar.cotacaoDolar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CotacaoDolar {

    @JsonIgnore
    private Integer requestId;

    @JsonIgnore
    private Timestamp requestTimestamp;

    private String dataCotacao;

    private Double cotacaoCompra;

    private Double cotacaoVenda;

    private String dataHoraCotacao;

}
