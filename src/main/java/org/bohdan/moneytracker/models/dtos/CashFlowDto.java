package org.bohdan.moneytracker.models.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashFlowDto
{
    BigDecimal total;
    BigDecimal incomes;
    BigDecimal expenses;
}
