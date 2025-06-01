package com.butecomananger.butecomananger.service;

import com.butecomananger.butecomananger.dto.CreateUserDto;
import com.butecomananger.butecomananger.dto.LoginUserDto;
import com.butecomananger.butecomananger.dto.RecoveryJwtTokenDto;
import com.butecomananger.butecomananger.exception.ValidationException;
import com.butecomananger.butecomananger.model.Role;
import com.butecomananger.butecomananger.model.User;
import com.butecomananger.butecomananger.repository.UserRepository;
import com.butecomananger.butecomananger.security.authentication.JwtTokenService;
import com.butecomananger.butecomananger.security.config.SecurityConfiguration;
import com.butecomananger.butecomananger.security.userdetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) throws BadCredentialsException{

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.password());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();//o que faz o metodo getPrincipal
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));

    }

    public void createUser(CreateUserDto createUserDto) {

        if (createUserDto.email() == null || createUserDto.email().isBlank()) {
            throw new ValidationException("Por favor informe o email");
        }

        if (createUserDto.password() == null || createUserDto.password().isBlank()) {
            throw new ValidationException("Por favor informe a senha");
        }

        if (createUserDto.role() == null) {
            throw new ValidationException("Informe as roles");
        }


        User user = User.builder()
                .email(createUserDto.email())
                .password(securityConfiguration.passwordEncoder().encode(createUserDto.password()))
                .roles(List.of(Role.builder().name(createUserDto.role()).build()))
                .build();

        userRepository.save(user);
    }
}
