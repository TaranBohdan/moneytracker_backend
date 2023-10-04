package org.bohdan.moneytracker.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletDto
{
    private Integer id;
    private String name;
    private BigDecimal balance;
    private String currency;
}
