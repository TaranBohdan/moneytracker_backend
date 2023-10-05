package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.entities.Wallet;

import java.util.List;

public interface WalletService
{
    List<Wallet> getAll();
    Wallet getById(Integer id);
    Wallet create(Wallet wallet);
    Wallet update(Wallet wallet, Integer id);
    void deleteById(Integer id);
}
