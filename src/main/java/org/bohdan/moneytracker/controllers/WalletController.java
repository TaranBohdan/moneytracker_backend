package org.bohdan.moneytracker.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.handlers.ResponseHandler;
import org.bohdan.moneytracker.mappers.WalletMapper;
import org.bohdan.moneytracker.models.dtos.WalletCreateDto;
import org.bohdan.moneytracker.models.dtos.WalletDto;
import org.bohdan.moneytracker.models.dtos.WalletUpdateDto;
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

    @Operation(description = "Get all wallets")
    @ApiResponse(responseCode = "200", description = "Wallets found")
    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> getAllWalletsOfUser()
    {
        try
        {
            List<Wallet> wallets = walletService.getAll();
            List<WalletDto> walletDtos = walletMapper.toDtoList(wallets);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, walletDtos, "Wallets");
        }
        catch (Exception e)
        {
            return ResponseHandler.generateError("Wallets were not found!", HttpStatus.NOT_FOUND);
        }
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
            return ResponseHandler.generateError("Wallet was not found. Please, try again!", HttpStatus.NOT_FOUND);
        }

        WalletDto walletDto = walletMapper.toDto(wallet);
        return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, walletDto, "Wallets");
    }

    @Operation(description = "Create wallet by id")
    @ApiResponse(responseCode = "200", description = "Wallet created")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> createWallet(@RequestBody WalletCreateDto walletCreateDto)
    {
        Wallet wallet = walletMapper.fromCreateDto(walletCreateDto);
        walletService.create(wallet, walletCreateDto);
        WalletDto walletDto = walletMapper.toDto(wallet);

        return ResponseHandler.generateResponse("Successfully created wallet!", HttpStatus.OK, walletDto, "Wallets");
    }

    @Operation(description = "Updating wallet with id")
    @ApiResponse(responseCode = "204", description = "Wallet updated")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> updateWallet(@PathVariable(name = "id") Integer id, @RequestBody WalletUpdateDto walletUpdateDto)
    {
        Wallet wallet = walletMapper.fromUpdateDto(walletUpdateDto, id);
        walletService.update(wallet, id, walletUpdateDto);
        WalletDto walletDto = walletMapper.toDto(wallet);

        return ResponseHandler.generateResponse("Successfully updated wallet!", HttpStatus.OK, walletDto, "Wallets");
    }

    @Operation(description = "Removing wallet with id")
    @ApiResponse(responseCode = "204", description = "Wallet removed")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> deleteWallet(@PathVariable(name = "id") Integer id)
    {
        walletService.deleteById(id);

        return ResponseHandler.generateResponse("Successfully deleted wallet!", HttpStatus.OK, null, "Data");
    }
}
