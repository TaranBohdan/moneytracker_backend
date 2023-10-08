package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.User;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.repositories.WalletRepository;
import org.bohdan.moneytracker.services.UserService;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService
{
    private final WalletRepository walletRepository;
    private final UserService userService;

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
    public Wallet create(Wallet wallet, WalletCreateDto walletCreateDto)
    {
        User user = userService.findByUsername(walletCreateDto.getUsernameOfUser()).orElse(null);
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteById(Integer id)
    {
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet update(Wallet wallet, Integer id, WalletUpdateDto walletUpdateDto)
    {
        wallet.setId(id);
        User user = userService.findByUsername(walletUpdateDto.getUsernameOfUser()).orElse(null);
        wallet.setUser(user);

        return walletRepository.save(wallet);
    }
}
