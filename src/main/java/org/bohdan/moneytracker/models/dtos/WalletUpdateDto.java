package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name = "WalletUpdate", description = "WalletUpdate")
public class WalletUpdateDto
{
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String usernameOfUser;
    @Schema(description = "WalletUpdate name", example = "Card")
    private String name;
    @Schema(description = "WalletUpdate balance", example = "1000")
    private BigDecimal balance;
    @Schema(description = "WalletUpdate currency", example = "EUR")
    private String currency;
}
