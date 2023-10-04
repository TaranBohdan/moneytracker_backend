package org.bohdan.moneytracker.controllers;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.mappers.WalletMapper;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController
{
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    @GetMapping("")
    public ResponseEntity<?> getAllWalletsOfUser()
    {
        List<Wallet> wallets = walletService.getAll();

        return ResponseEntity.ok(walletMapper.toDtoList(wallets));
    }
}
