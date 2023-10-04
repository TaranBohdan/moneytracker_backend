package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.repositories.WalletRepository;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService
{
    private final WalletRepository walletRepository;

    @Override
    public List<Wallet> getAll()
    {
        return walletRepository.findAll();
    }
}
