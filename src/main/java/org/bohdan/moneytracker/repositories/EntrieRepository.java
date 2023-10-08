package org.bohdan.moneytracker.repositories;

import org.bohdan.moneytracker.models.entities.Entrie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrieRepository extends JpaRepository<Entrie, Integer>
{
}
