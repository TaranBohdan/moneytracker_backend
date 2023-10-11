package org.bohdan.moneytracker.repositories;

import org.bohdan.moneytracker.models.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>
{
    List<Wallet> findByUserId(Long user_id);
}
