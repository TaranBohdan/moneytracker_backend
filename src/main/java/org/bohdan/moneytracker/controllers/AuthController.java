package org.bohdan.moneytracker.controllers;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.models.dtos.LoginDto;
import org.bohdan.moneytracker.models.dtos.SignupDto;
import org.bohdan.moneytracker.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController
{
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupDto signupDto)
    {
        return authService.signUp(signupDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
        return authService.login(loginDto);
    }
}
