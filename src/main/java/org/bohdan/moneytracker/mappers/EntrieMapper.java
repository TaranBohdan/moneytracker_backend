package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntrieMapper
{
    List<EntrieDto> toDtoList(List<Entrie> entries);
//    @Mapping(source = "wallet.id", target = "walletId")
//    EntrieDto toDto(Entrie entrie);
}