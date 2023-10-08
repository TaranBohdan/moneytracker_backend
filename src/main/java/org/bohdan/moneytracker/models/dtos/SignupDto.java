package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Signup", description = "Signup")
public class SignupDto
{
    @Schema(description = "Signup username", example = "username")
    private String username;
    @Schema(description = "Signup password", example = "password")
    private String password;
    @Schema(description = "Signup confirmPassword", example = "confirmPassword")
    private String confirmPassword;
}
