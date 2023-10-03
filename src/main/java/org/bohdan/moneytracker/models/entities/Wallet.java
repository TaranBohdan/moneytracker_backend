package org.bohdan.moneytracker.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
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
}
