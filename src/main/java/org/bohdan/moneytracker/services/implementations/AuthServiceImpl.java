package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.handlers.ResponseHandler;
import org.bohdan.moneytracker.models.dtos.LoginDto;
import org.bohdan.moneytracker.models.dtos.SignupDto;
import org.bohdan.moneytracker.models.dtos.TokenResponseDto;
import org.bohdan.moneytracker.models.dtos.UserDto;
import org.bohdan.moneytracker.models.entities.User;
import org.bohdan.moneytracker.services.AuthService;
import org.bohdan.moneytracker.services.UserService;
import org.bohdan.moneytracker.utilities.JwtTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;

    @Override
    public ResponseEntity<?> signUp(SignupDto signupDto)
    {
        String username = signupDto.getUsername();
        String password = signupDto.getPassword();
        String confirmPassword = signupDto.getConfirmPassword();

        if (!password.equals(confirmPassword))
        {
            return ResponseHandler.generateError("Passwords must match!", HttpStatus.BAD_REQUEST);
        }

        if (userService.findByUsername(username).isPresent())
        {
            return ResponseHandler.generateError("A user with the same username is already registered!", HttpStatus.BAD_REQUEST);
        }

        User user = userService.createNewUser(signupDto);

        return ResponseHandler.generateResponse(
                "User was created successfully!",
                HttpStatus.OK,
                new UserDto(user.getId(), user.getUsername()),"users");
    }

    @Override
    public ResponseEntity<?> login(LoginDto loginDto)
    {
        String username = loginDto.getUsername();
        String password = loginDto.getPassword();

        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (BadCredentialsException e)
        {
            if (userService.findByUsername(username).isPresent())
            {
                return ResponseHandler.generateError("Incorrect username or password!", HttpStatus.UNAUTHORIZED);
            }
        }

        UserDetails userDetails = userService.loadUserByUsername(username);
        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseHandler.generateResponse(
                "Token was generated successfully!",
                HttpStatus.OK,
                new TokenResponseDto(token), "tokens");
    }
}
