package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "TokenResponse", description = "TokenResponse")
public class TokenResponseDto
{
    @Schema(description = "TokenResponse token", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwicm9sZXMiOlsiUk9MRV9VU0VSIl0sImV4cCI6MTY5Njc3OTY1OSwiaWF0IjoxNjk2Nzc3ODU5fQ.hTSGvfA5KF95OjHL4TOQBvmtB9fac_JeoZEYdWaH_h0")
    private String token;
}
