package org.bohdan.moneytracker.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletCreateDto
{
    private String usernameOfUser;
    private String name;
    private BigDecimal balance;
    private String currency;
}