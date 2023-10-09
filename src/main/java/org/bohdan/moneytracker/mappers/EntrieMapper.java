package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntrieMapper
{
    List<EntrieDto> toDtoList(List<Entrie> entries);
    @Mapping(source = "wallet.name", target = "name_wallet")
    EntrieDto toDto(Entrie entrie);
}