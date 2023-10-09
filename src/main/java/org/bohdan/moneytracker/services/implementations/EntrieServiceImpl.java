package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.*;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.repositories.EntrieRepository;
import org.bohdan.moneytracker.repositories.WalletRepository;
import org.bohdan.moneytracker.services.EntrieService;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrieServiceImpl implements EntrieService
{
    private final EntrieRepository entrieRepository;
    private final WalletService walletService;
    private final WalletRepository walletRepository;

    @Override
    public List<Entrie> getAll()
    {
        return entrieRepository.findAll();
    }

    @Override
    public Entrie create(Entrie entrie, EntrieCreateDto entrieCreateDto)
    {
        Wallet wallet = walletService.getById(entrieCreateDto.getWallet_id());

        entrie.setDate(new Date(System.currentTimeMillis()));
        entrie.setCurrency(wallet.getCurrency());

        String incomeOrExpenses = entrieCreateDto.getType();
        if (incomeOrExpenses.equalsIgnoreCase("expense"))
        {
            BigDecimal currentBalanceOfWallet = wallet.getBalance();
            BigDecimal valueOfEntrie = entrieCreateDto.getValue();

            wallet.setBalance(currentBalanceOfWallet.subtract(valueOfEntrie));
            walletRepository.save(wallet);
        }
        if (incomeOrExpenses.equalsIgnoreCase("income"))
        {
            BigDecimal currentBalanceOfWallet = wallet.getBalance();
            BigDecimal valueOfEntrie = entrieCreateDto.getValue();

            wallet.setBalance(currentBalanceOfWallet.add(valueOfEntrie));
            walletRepository.save(wallet);
        }

        entrie.setWallet(wallet);
        return entrieRepository.save(entrie);
    }

    @Override
    public Entrie getById(Entrie id)
    {
        return null;
    }

    @Override
    public Entrie update(Entrie entrie, Integer wallet_id, EntrieUpdateDto entrieUpdateDto)
    {
        Wallet wallet = walletService.getById(wallet_id);

        entrie.setType(entrie.getType());
        entrie.setNote(entrieUpdateDto.getNote());
        entrie.setCategory(entrieUpdateDto.getCategory());
        entrie.setValue(entrie.getValue());
        entrie.setDate(entrieUpdateDto.getDate());
        entrie.setWallet(wallet);
        entrie.setCurrency(wallet.getCurrency());

        return entrieRepository.save(entrie);
    }

    @Override
    public void deleteById(Integer id)
    {
        entrieRepository.deleteById(id);
    }
}
