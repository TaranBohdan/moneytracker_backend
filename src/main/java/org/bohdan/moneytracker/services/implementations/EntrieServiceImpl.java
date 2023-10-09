package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.EntrieCreateDto;
import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.repositories.EntrieRepository;
import org.bohdan.moneytracker.repositories.WalletRepository;
import org.bohdan.moneytracker.services.EntrieService;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrieServiceImpl implements EntrieService
{
    private final EntrieRepository entrieRepository;
    private final WalletService walletService;

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
        entrie.setWallet(wallet);

        return entrieRepository.save(entrie);
    }

    @Override
    public Entrie getById(Entrie id)
    {
        return null;
    }

    @Override
    public void deleteById(Integer id)
    {

    }
}
