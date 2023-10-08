package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Login", description = "Login")
public class LoginDto
{
    @Schema(description = "Login username", example = "username")
    private String username;
    @Schema(description = "Login password", example = "password")
    private String password;
}
