package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.entities.Entrie;
import org.bohdan.moneytracker.repositories.EntrieRepository;
import org.bohdan.moneytracker.services.EntrieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntrieServiceImpl implements EntrieService
{
    private final EntrieRepository entrieRepository;

    @Override
    public List<Entrie> getAll()
    {
        return entrieRepository.findAll();
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
