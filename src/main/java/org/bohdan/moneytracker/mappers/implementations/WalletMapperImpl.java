package org.bohdan.moneytracker.mappers.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.mappers.WalletMapper;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.services.WalletService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class WalletMapperImpl implements WalletMapper
{
    private final WalletService walletService;

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

    @Override
    public Wallet walletDtoToWallet(WalletDto walletDto)
    {
        Wallet wallet = new Wallet();

        wallet.setName(walletDto.getName());
        wallet.setBalance(walletDto.getBalance());
        wallet.setCurrency(walletDto.getCurrency());

        return wallet;
    }

    @Override
    public Wallet walletCreateDtoToWallet(WalletCreateDto walletCreateDto)
    {
        Wallet wallet = new Wallet();

        wallet.setName(walletCreateDto.getName());
        wallet.setBalance(walletCreateDto.getBalance());
        wallet.setCurrency(walletCreateDto.getCurrency());

        return wallet;
    }

    @Override
    public Wallet walletUpdateDtoToWallet(WalletUpdateDto walletUpdateDto, Integer id)
    {
        Wallet wallet = walletService.getById(id);

        wallet.setName(walletUpdateDto.getName());
        wallet.setBalance(walletUpdateDto.getBalance());
        wallet.setCurrency(walletUpdateDto.getCurrency());

        return wallet;
    }
}
