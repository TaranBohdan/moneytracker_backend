package org.bohdan.moneytracker.models.dtos;

import lombok.Data;

@Data
public class SignupDto
{
    private String username;
    private String password;
    private String confirmPassword;
}
