package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.entities.Role;
import org.bohdan.moneytracker.repositories.RoleRepository;
import org.bohdan.moneytracker.services.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService
{
    private final RoleRepository roleRepository;

    @Override
    public Role getRole()
    {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
