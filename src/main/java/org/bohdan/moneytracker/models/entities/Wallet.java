package org.bohdan.moneytracker.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "wallets")
@Data
public class Wallet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency")
    private String currency;

    @ManyToMany
    @JoinTable
            (
                    name = "users_wallets",
                    joinColumns = @JoinColumn(name = "wallet_id"),
                    inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    private List<User> users;
}
