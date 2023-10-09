package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.dtos.EntrieCreateDto;
import org.bohdan.moneytracker.models.dtos.EntrieDto;
import org.bohdan.moneytracker.models.dtos.EntrieUpdateDto;
import org.bohdan.moneytracker.models.entities.Entrie;

import java.util.List;

public interface EntrieService
{
    List<Entrie> getAll();
    Entrie getById(Entrie id);
    Entrie create(Entrie entrie, EntrieCreateDto entrieCreateDto);
    Entrie update(Entrie entrie, Integer wallet_id, EntrieUpdateDto entrieUpdateDto);
    void deleteById(Integer id);
}
