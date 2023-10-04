package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.entities.User;

import java.util.Optional;

public interface UserService
{
    Optional<User> findByUsername(String username);
}
