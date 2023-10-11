package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.dtos.CashFlowDto;
import org.bohdan.moneytracker.models.dtos.UserDto;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService
{
    List<Wallet> getAll();
    Wallet getById(Integer id);
    Wallet create(Wallet wallet, WalletCreateDto walletCreateDto);
    Wallet update(Wallet wallet, Integer id, WalletUpdateDto walletUpdateDto);
    BigDecimal getGeneralBalance(UserDto userDto);
    BigDecimal getExpenses(UserDto userDto);
    BigDecimal getIncomes(UserDto userDto);
    CashFlowDto getCashFlow(UserDto userDto);
    void deleteById(Integer id);
}
