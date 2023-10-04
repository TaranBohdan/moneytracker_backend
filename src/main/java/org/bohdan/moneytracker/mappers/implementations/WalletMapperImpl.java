package org.bohdan.moneytracker.mappers.implementations;

import org.bohdan.moneytracker.mappers.WalletMapper;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.entities.Wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletMapperImpl implements WalletMapper
{
    @Override
    public List<WalletDto> toDtoList(List<Wallet> wallets)
    {
        if (wallets == null)
        {
            return null;
        }

        List<WalletDto> list = new ArrayList<WalletDto>();

        for (Wallet wallet : wallets)
        {
            list.add(walletToWalletDto(wallet));
        }

        return list;
    }

    @Override
    public WalletDto walletToWalletDto(Wallet wallet)
    {
        if (wallet == null)
        {
            return null;
        }

        WalletDto walletDto = new WalletDto();

        walletDto.setId(wallet.getId());
        walletDto.setName(wallet.getName());
        walletDto.setBalance(wallet.getBalance());
        walletDto.setCurrency(wallet.getCurrency());

        return walletDto;
    }
}
