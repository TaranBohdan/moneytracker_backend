package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.bohdan.moneytracker.models.entities.Wallet;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Schema(name = "Entrie", description = "Entrie")
public class EntrieDto
{
    @Schema(description = "Entrie id", example = "0")
    private Integer id;

    @Schema(description = "Entrie note", example = "One day ticket")
    private String note;

    @Schema(description = "Entrie value", example = "100")
    private BigDecimal value;

    @Schema(description = "Entrie category", example = "Transport")
    private String category;

    @Schema(description = "Entrie type", example = "Expense")
    private String type;

    @Schema(description = "Entrie date", example = "01.01.2001")
    private Date date;
}
