package org.bohdan.moneytracker.repositories;

import org.bohdan.moneytracker.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>
{
    Optional<Role> findByName(String name);
}
