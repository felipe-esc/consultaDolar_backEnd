package org.consultaDolar.cotacaoDolar.service;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.consultaDolar.cotacaoDolar.CotacaoDolar;
import org.consultaDolar.cotacaoDolar.repository.CotacaoDolarRepository;
import org.consultaDolar.cotacaoDolar.repository.entity.CotacaoDolarEntity;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@QuarkusTest
class CotacaoDolarServiceTest {

    @InjectMock
    private CotacaoDolarRepository cotacaoDolarRepositoryMock;

    @Inject
    private CotacaoDolarService cotacaoDolarService;

    @Test
    public void testCotacaoDolarDia() {
        doNothing().when(cotacaoDolarRepositoryMock).persist(any(CotacaoDolarEntity.class));

        cotacaoDolarService.save(createCotacaoDolar());

        verify(cotacaoDolarRepositoryMock, times(1)).persist(any(CotacaoDolarEntity.class));
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