package org.bohdan.moneytracker.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
@RequiredArgsConstructor
@Tag(name = "Entrie", description = "Entrie management")
public class EntrieController
{
    @Operation(description = "Get all wallets")
    @ApiResponse(responseCode = "200", description = "Wallets found")
    @GetMapping("")
    public ResponseEntity<?> getAll()
    {
        return null;
    }
}
