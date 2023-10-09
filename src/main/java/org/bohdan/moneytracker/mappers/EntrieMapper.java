package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.EntrieCreateDto;
import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.dtos.EntrieUpdateDto;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntrieMapper
{
    List<EntrieDto> toDtoList(List<Entrie> entries);

    @Mapping(source = "wallet.currency", target = "currency")
    EntrieDto toDto(Entrie entrie);

    Entrie fromCreateDto(EntrieCreateDto entrieCreateDto);

    Entrie fromUpdateDto(EntrieUpdateDto entrieUpdateDto, Integer id);
}