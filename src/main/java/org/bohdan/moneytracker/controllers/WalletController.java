package org.bohdan.moneytracker.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.exceptions.AppError;
import org.bohdan.moneytracker.mappers.WalletMapper;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
import org.bohdan.moneytracker.models.entities.User;
import org.bohdan.moneytracker.models.entities.Wallet;
import org.bohdan.moneytracker.services.UserService;
import org.bohdan.moneytracker.services.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
@Tag(name = "Wallet", description = "Wallet management")
@ApiResponse(responseCode = "500", description = "Internal error")
@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "Wallet not found")
public class WalletController
{
    private final WalletService walletService;
    private final WalletMapper walletMapper;
    private final UserService userService;

    @Operation(description = "Get all wallets")
    @ApiResponse(responseCode = "200", description = "Wallets found")
    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> getAllWalletsOfUser()
    {
        List<Wallet> wallets = walletService.getAll();

        return ResponseEntity.ok(walletMapper.toDtoList(wallets));
    }

    @Operation(description = "Get wallet by id")
    @ApiResponse(responseCode = "200", description = "Wallet found")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> getWallet(@PathVariable(name = "id") Integer id)
    {
        Wallet wallet = walletService.getById(id);
        if (wallet == null)
        {
            return new ResponseEntity(new AppError(
                    HttpStatus.NOT_FOUND.value(), String.format("Wallet wasn't found with id=%s", id)
            ), HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(walletMapper.walletToWalletDto(wallet));
    }

    @Operation(description = "Get wallet by id")
    @ApiResponse(responseCode = "200", description = "Wallet created")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> createWallet(@RequestBody WalletCreateDto walletCreateDto)
    {
        Wallet wallet = walletMapper.walletCreateDtoToWallet(walletCreateDto);
        User user = userService.findByUsername(walletCreateDto.getUsernameOfUser()).orElse(null);

        wallet.setUsers(List.of(user));
        walletService.create(wallet);

        WalletDto walletDto = walletMapper.walletToWalletDto(wallet);

        return ResponseEntity.ok(walletDto);
    }

    @Operation(description = "Updating wallet with id")
    @ApiResponse(responseCode = "204", description = "Wallet updated")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> updateWallet(@PathVariable(name = "id") Integer id, @RequestBody WalletUpdateDto walletUpdateDto)
    {
        Wallet wallet = walletMapper.walletUpdateDtoToWallet(walletUpdateDto, id);
        User user = userService.findByUsername(walletUpdateDto.getUsernameOfUser()).orElse(null);

        wallet.setUsers(List.of(user));
        walletService.update(wallet, id);

        WalletDto walletDto = walletMapper.walletToWalletDto(wallet);

        return ResponseEntity.ok(walletDto);
    }

    @Operation(description = "Removing wallet with id")
    @ApiResponse(responseCode = "204", description = "Wallet removed")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void deleteWallet(@PathVariable(name = "id") Integer id)
    {
        walletService.deleteById(id);
    }
}
