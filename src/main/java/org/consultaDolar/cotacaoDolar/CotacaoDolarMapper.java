package org.consultaDolar.cotacaoDolar;

import org.consultaDolar.cotacaoDolar.repository.entity.CotacaoDolarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jakarta")
public interface CotacaoDolarMapper {

    List<CotacaoDolar> toDomainList(List<CotacaoDolarEntity> cotacaoDolarList);

    CotacaoDolar toDomain(CotacaoDolarEntity cotacaoDolar);

    @InheritInverseConfiguration(name = "toDomain")
    CotacaoDolarEntity toEntity(CotacaoDolar cotacaoDolar);

}
