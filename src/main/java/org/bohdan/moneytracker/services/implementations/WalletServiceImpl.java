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

    @Override
    public Wallet getById(Integer id)
    {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public Wallet create(Wallet wallet)
    {
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteById(Integer id)
    {
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet update(Wallet wallet, Integer id)
    {
        wallet.setId(id);

        return walletRepository.save(wallet);
    }
}
