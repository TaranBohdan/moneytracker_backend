package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name = "Wallet", description = "Wallet")
public class WalletDto
{
    @Schema(description = "Wallet id", example = "1")
    private Integer id;
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer userId;
    @Schema(description = "Wallet name", example = "Card")
    private String name;
    @Schema(description = "Wallet balance", example = "1000")
    private BigDecimal balance;
    @Schema(description = "Wallet currency", example = "EUR")
    private String currency;
}
