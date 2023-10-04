package org.bohdan.moneytracker.repositories;

import org.bohdan.moneytracker.models.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>
{
}
