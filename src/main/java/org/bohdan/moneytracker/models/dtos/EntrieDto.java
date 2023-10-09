package org.bohdan.moneytracker.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Schema(name = "Entrie", description = "Entrie")
public class EntrieDto
{
    @Schema(description = "Entrie id", example = "0")
    private Integer id;

    @Schema(description = "Entrie name_wallet", example = "Card")
    private String name_wallet;

    @Schema(description = "Entrie note", example = "One day ticket")
    private String note;

    @Schema(description = "Entrie value", example = "100")
    private BigDecimal value;

    @Schema(description = "Entrie currency", example = "EUR")
    private String currency;

    @Schema(description = "Entrie category", example = "Transport")
    private String category;

    @Schema(description = "Entrie type", example = "Expense")
    private String type;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Schema(description = "Entrie date", example = "01.01.2001")
    private Date date;
}
