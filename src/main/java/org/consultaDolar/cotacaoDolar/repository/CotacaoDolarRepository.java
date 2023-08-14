package org.consultaDolar.cotacaoDolar.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.consultaDolar.cotacaoDolar.repository.entity.CotacaoDolarEntity;

@ApplicationScoped
public class CotacaoDolarRepository implements PanacheRepositoryBase<CotacaoDolarEntity, Integer> {
}
