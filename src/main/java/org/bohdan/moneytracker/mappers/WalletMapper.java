package org.bohdan.moneytracker.mappers;

import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WalletMapper
{
    List<WalletDto> toDtoList(List<Wallet> wallets);
    WalletDto walletToWalletDto(Wallet wallet);
    Wallet walletDtoToWallet(WalletDto walletDto);
    Wallet walletCreateDtoToWallet(WalletCreateDto walletCreateDto);
    Wallet walletUpdateDtoToWallet(WalletUpdateDto walletUpdateDto, Integer id);
}
