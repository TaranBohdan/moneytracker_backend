package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Wallet;

import java.util.List;

public interface WalletService
{
    List<Wallet> getAll();
    Wallet getById(Integer id);
    Wallet create(Wallet wallet, WalletCreateDto walletCreateDto);
    Wallet update(Wallet wallet, Integer id, WalletUpdateDto walletUpdateDto);
    void deleteById(Integer id);
}
