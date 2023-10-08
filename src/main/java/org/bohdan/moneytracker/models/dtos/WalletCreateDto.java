package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name = "WalletCreate", description = "WalletCreate")
public class WalletCreateDto
{
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String usernameOfUser;

    @Schema(description = "WalletCreate name", example = "Card")
    private String name;

    @Schema(description = "WalletCreate balance", example = "1000")
    private BigDecimal balance;

    @Schema(description = "WalletCreate currency", example = "EUR")
    private String currency;
}