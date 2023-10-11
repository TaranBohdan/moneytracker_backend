package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.CashFlowDto;
import org.bohdan.moneytracker.models.dtos.UserDto;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.User;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.repositories.WalletRepository;
import org.bohdan.moneytracker.services.UserService;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService
{
    private final WalletRepository walletRepository;
    private final UserService userService;

    @Override
    public List<Wallet> getAll()
    {
        return walletRepository.findAll();
    }

    @Override
    public Wallet getById(Integer id)
    {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public Wallet create(Wallet wallet, WalletCreateDto walletCreateDto)
    {
        User user = userService.findByUsername(walletCreateDto.getUsernameOfUser()).orElse(null);
        wallet.setUser(user);
        return walletRepository.save(wallet);
    }

    @Override
    public BigDecimal getGeneralBalance(UserDto userDto)
    {
        List<Wallet> wallets = getAll();
        BigDecimal generalBalance = new BigDecimal(0.0);
        String usernameOfUser = userDto.getUsername();

        for (Wallet wallet : wallets)
        {
            if (wallet.getUser().getUsername().equals(usernameOfUser))
            {
                generalBalance = generalBalance.add(wallet.getBalance());
            }
        }

        return generalBalance;
    }

    @Override
    public BigDecimal getIncomes(UserDto userDto)
    {
        List<Wallet> wallets = getAll();
        String usernameOfUser = userDto.getUsername();
        BigDecimal amountOfIncome = new BigDecimal(0.0);

        for (Wallet wallet : wallets)
        {
            if (wallet.getUser().getUsername().equals(usernameOfUser))
            {
                int i = 0;
                String typeOfEntrie = wallet.getEntries().get(i).getType();
                if (typeOfEntrie.toLowerCase().equals("income"))
                {
                    amountOfIncome = amountOfIncome.add(wallet.getEntries().get(i).getValue());
                    i++;
                }
            }
        }

        return amountOfIncome;
    }

    @Override
    public BigDecimal getExpenses(UserDto userDto)
    {
        List<Wallet> wallets = getAll();
        String usernameOfUser = userDto.getUsername();
        BigDecimal amountOfExpenses = new BigDecimal(0.0);

        for (Wallet wallet : wallets)
        {
            if (wallet.getUser().getUsername().equals(usernameOfUser))
            {
                int i = 0;
                String typeOfEntrie = wallet.getEntries().get(i).getType();
                if (typeOfEntrie.toLowerCase().equals("expense"))
                {
                    amountOfExpenses = amountOfExpenses.add(wallet.getEntries().get(i).getValue());
                    i++;
                }
            }
        }

        return amountOfExpenses;
    }

    @Override
    public CashFlowDto getCashFlow(UserDto userDto)
    {
        BigDecimal expenses = getExpenses(userDto);
        BigDecimal incomes = getIncomes(userDto);
        BigDecimal total = incomes.subtract(expenses);

        CashFlowDto cashFlowDto = new CashFlowDto();
        cashFlowDto.setExpenses(expenses);
        cashFlowDto.setIncomes(incomes);
        cashFlowDto.setTotal(total);

        return cashFlowDto;
    }

    @Override
    public void deleteById(Integer id)
    {
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet update(Wallet wallet, Integer id, WalletUpdateDto walletUpdateDto)
    {
        User user = userService.findByUsername(walletUpdateDto.getUsernameOfUser()).orElse(null);

        wallet.setId(id);
        wallet.setUser(user);
        wallet.setName(wallet.getName());
        wallet.setBalance(walletUpdateDto.getBalance());
        wallet.setCurrency(walletUpdateDto.getCurrency());

        return walletRepository.save(wallet);
    }
}
