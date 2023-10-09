package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(name = "EntrieCreate", description = "EntrieCreate")
public class EntrieCreateDto
{
    @Schema(description = "EntrieCreate id", example = "1")
    private Integer wallet_id;

    @Schema(description = "EntrieCreate note", example = "One day ticket")
    private String note;

    @Schema(description = "EntrieCreate value", example = "100")
    private BigDecimal value;

    @Schema(description = "EntrieCreate currency", example = "EUR")
    private String currency;

    @Schema(description = "EntrieCreate category", example = "Transport")
    private String category;

    @Schema(description = "EntrieCreate type", example = "Expense")
    private String type;
}
