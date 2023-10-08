package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.entities.Entrie;

import java.util.List;

public interface EntrieService
{
    List<Entrie> getAll();
    Entrie getById(Entrie id);
//    Entrie create(Entrie wallet, WalletCreateDto walletCreateDto);
//    Entrie update(Entrie wallet, Integer id, WalletUpdateDto walletUpdateDto);
    void deleteById(Integer id);
}
