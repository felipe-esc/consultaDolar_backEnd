package org.consultaDolar.cotacaoDolar.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.consultaDolar.cotacaoDolar.CotacaoDolarMapper;
import org.consultaDolar.cotacaoDolar.repository.CotacaoDolarRepository;

import java.sql.Timestamp;
import java.time.Instant;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class CotacaoDolarService {

    private final CotacaoDolarRepository cotacaoDolarRepository;

    private final CotacaoDolarMapper cotacaoDolarMapper;

    @Transactional
    public void save(@NotNull CotacaoDolar cotacaoDolar) {
        log.info("Salvando cotacao:" + cotacaoDolar);

        cotacaoDolarRepository.persist(
                cotacaoDolarMapper.toEntity(cotacaoDolar)
        );
    }
}
