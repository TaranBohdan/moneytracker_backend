package org.bohdan.moneytracker.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany
            (
                    mappedBy = "user",
                    fetch = FetchType.EAGER,
                    cascade = CascadeType.ALL
            )
    private List<Wallet> wallets;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
            (
                    name = "users_roles",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private List<Role> roles;
}
