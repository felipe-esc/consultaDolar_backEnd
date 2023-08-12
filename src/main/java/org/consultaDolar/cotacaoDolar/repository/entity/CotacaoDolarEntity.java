package org.consultaDolar.cotacaoDolar.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity(name = "cotacaoDolar")
@Table(name = "cotacaoDolar")
@Data
public class CotacaoDolarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer id;

    @Column(name = "request_timestamp")
    private Timestamp requestTimestamp;

    @Column(name = "data_cotacao")
    private String dataCotacao;

    @Column(name = "cotacao_compra")
    private Double cotacaoCompra;

    @Column(name = "cotacao_venda")
    private Double cotacaoVenda;

    @Column(name = "data_hora_cotacao")
    private Timestamp dataHoraCotacao;
}
