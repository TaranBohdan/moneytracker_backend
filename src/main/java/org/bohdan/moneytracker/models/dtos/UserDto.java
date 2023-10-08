package org.bohdan.moneytracker.models.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(name = "User", description = "User")
public class UserDto
{
    @Schema(description = "User id", example = "1")
    private Long id;
    @Schema(description = "User username", example = "username")
    private String username;
}
