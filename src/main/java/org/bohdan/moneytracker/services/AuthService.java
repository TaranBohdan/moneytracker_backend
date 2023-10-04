package org.bohdan.moneytracker.services;

import org.bohdan.moneytracker.models.dtos.LoginDto;
import org.bohdan.moneytracker.models.dtos.SignupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService
{
    ResponseEntity<?> signUp(@RequestBody SignupDto signupDto);
    ResponseEntity<?> login(@RequestBody LoginDto loginDto);
}
