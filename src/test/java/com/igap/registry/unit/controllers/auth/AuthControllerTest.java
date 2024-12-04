package com.igap.registry.unit.controllers.auth;

import com.igap.registry.controllers.auth.AuthController;
import com.igap.registry.dto.auth.request.LoginRequest;
import com.igap.registry.dto.auth.request.RegisterRequest;
import com.igap.registry.dto.auth.response.LoginResponse;
import com.igap.registry.entities.core.user.User;
import com.igap.registry.repositories.user.UserRepository;
import com.igap.registry.security.jwt.utils.JwtUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Joe Monkila
 */

class AuthControllerTest {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;
    private AuthController authController;

    @BeforeEach
    void setUp() {
        authenticationManager = mock(AuthenticationManager.class);
        userRepository = mock(UserRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        jwtUtils = mock(JwtUtils.class);

        authController = new AuthController(authenticationManager, userRepository, passwordEncoder, jwtUtils);
    }

    @SuppressWarnings("deprecation")
    @Test
    void testAuthenticateUser_Success() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("monkila");
        loginRequest.setPassword("1234");

        User user = new User();
        user.setUsername("monkila");

        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(user);
        when(jwtUtils.generateJwtToken("monkila", 36000)).thenReturn(Map.of("cookie", "jwt-token"));

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);

        assertEquals(200, response.getStatusCodeValue());
        @SuppressWarnings("rawtypes")
        LoginResponse loginResponse = (LoginResponse) response.getBody();
        assertEquals("Authentification réussie.", loginResponse.getMessage());
        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    void testAuthenticateUser_BadCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("monkila");
        loginRequest.setPassword("1234");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Bad credentials"));

        ResponseEntity<?> response = authController.authenticateUser(loginRequest);

        assertEquals(401, response.getStatusCode().value());
        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    void testRegisterUser_Success() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("monkila");
        registerRequest.setEmail("jnkiwa25@gmail.com");
        registerRequest.setPassword("1234");

        when(userRepository.findByUsername("monkila")).thenReturn(null);
        when(userRepository.findByEmail("jnkiwa25@gmail.com")).thenReturn(null);
        when(passwordEncoder.encode("1234")).thenReturn("encoded-password");

        ResponseEntity<?> response = authController.registerUser(registerRequest);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Utilisateur enregistré avec succès !", response.getBody());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUser_UsernameAlreadyExists() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("monkila");
        registerRequest.setEmail("jnkiwa25@gmail.com");

        User user = new User();
        user.setUsername("monkila");

        when(userRepository.findByUsername("monkila")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = authController.registerUser(registerRequest);

        assertEquals(400, response.getStatusCode().value());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testDisableUser_Success() {
        User user = new User();
        user.setUsername("monkila");
        user.setEnabled(true);

        when(userRepository.findByUsername("monkila")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = authController.disableUser("monkila");

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Compte désactivé avec succès.", response.getBody());
        verify(userRepository, times(1)).save(user);
        assertEquals(false, user.isEnabled());
    }

    @Test
    void testDisableUser_UserNotFound() {
        when(userRepository.findByUsername("unknownuser")).thenReturn(Optional.empty());

        ResponseEntity<?> response = authController.disableUser("unknownuser");

        assertEquals(404, response.getStatusCode().value());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testEnableUser_Success() {
        User user = new User();
        user.setUsername("monkila");
        user.setEnabled(false);

        when(userRepository.findByUsername("monkila")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = authController.enableUser("monkila");

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Compte activé avec succès.", response.getBody());
        verify(userRepository, times(1)).save(user);
        assertEquals(true, user.isEnabled());
    }
}
