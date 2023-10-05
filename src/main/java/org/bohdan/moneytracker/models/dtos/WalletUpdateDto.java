package org.bohdan.moneytracker.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletUpdateDto
{
    private String usernameOfUser;
    private String name;
    private BigDecimal balance;
    private String currency;
}
