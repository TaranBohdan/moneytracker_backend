package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.entities.Wallet;

import java.util.List;

public interface WalletService
{
    List<Wallet> getAll();
    //Wallet create(Wallet walletToCreate);
}
