package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Schema(name = "EntrieUpdate", description = "EntrieUpdate")
public class EntrieUpdateDto
{
    @Schema(description = "EntrieUpdate note", example = "One day ticket")
    private String note;

    @Schema(description = "EntrieUpdate value", example = "100")
    private BigDecimal value;

    @Schema(description = "EntrieUpdate category", example = "Transport")
    private String category;

    @Schema(description = "EntrieUpdate type", example = "Expense")
    private String type;

    @Schema(description = "EntrieUpdate date", example = "01.01.2001")
    private Date date;
}
