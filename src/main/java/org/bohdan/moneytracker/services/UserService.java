package org.bohdan.moneytracker.services;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.SignupDto;
import org.bohdan.moneytracker.models.entities.User;
import org.bohdan.moneytracker.repositories.RoleRepository;
import org.bohdan.moneytracker.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService
{
    private final UserRepository userRepository;
    private final RoleService roleService;

    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User wasn't found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }

    public User createNewUser(SignupDto signupDto)
    {
        User user = new User();

        user.setUsername(signupDto.getUsername());
        user.setPassword(signupDto.getPassword());
        user.setRoles(List.of(roleService.getRole()));

        return userRepository.save(user);
    }
}
