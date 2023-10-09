package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.bohdan.moneytracker.models.entities.Entrie;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(name = "Wallet", description = "Wallet")
public class WalletDto
{
    @Schema(description = "Wallet id", example = "1")
    private Integer id;

    @Schema(description = "Wallet owner username", example = "username")
    private String owner_username;

    @Schema(description = "Wallet name", example = "Card")
    private String name;

    @Schema(description = "Wallet balance", example = "1000")
    private BigDecimal balance;

    @Schema(description = "Wallet currency", example = "EUR")
    private String currency;

    @Schema(description = "Wallet entries", example = "[]")
    private List<Entrie> entries;
}
