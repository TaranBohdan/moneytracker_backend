package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WalletMapper
{
    List<WalletDto> toDtoList(List<Wallet> wallets);
    @Mapping(source = "user.id", target = "userId")
    WalletDto toDto(Wallet wallet);
    Wallet fromCreateDto(WalletCreateDto walletCreateDto);
    Wallet fromUpdateDto(WalletUpdateDto walletUpdateDto, Integer id);
}
