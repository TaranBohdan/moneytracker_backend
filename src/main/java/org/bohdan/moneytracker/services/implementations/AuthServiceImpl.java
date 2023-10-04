package org.bohdan.moneytracker.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bohdan.moneytracker.exceptions.AppError;
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
            return new ResponseEntity(new AppError(
                    HttpStatus.BAD_REQUEST.value(), "Passwords must match!"
            ), HttpStatus.BAD_REQUEST);
        }

        if (userService.findByUsername(username).isPresent())
        {
            return new ResponseEntity(new AppError(
                    HttpStatus.BAD_REQUEST.value(), "A user with the same username is already registered!"
            ), HttpStatus.BAD_REQUEST);
        }

        User user = userService.createNewUser(signupDto);

        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername()));
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
                return new ResponseEntity(new AppError(
                        HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password!"
                ), HttpStatus.UNAUTHORIZED);
            }
        }

        UserDetails userDetails = userService.loadUserByUsername(username);
        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponseDto(token));
    }
}
