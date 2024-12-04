package com.igap.registry.controllers.auth;

import com.igap.registry.dto.auth.request.LoginRequest;
import com.igap.registry.dto.auth.request.RegisterRequest;
import com.igap.registry.dto.auth.response.LoginResponse;
import com.igap.registry.dto.utils.ErrorResponse;
import com.igap.registry.entities.core.user.User;
import com.igap.registry.helper.MessageException;
import com.igap.registry.repositories.user.UserRepository;
import com.igap.registry.security.jwt.utils.JwtUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @author Joe Monkila
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/accounts/")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(
            AuthenticationManager authenticationManager,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));

            User userDetails = (User) authentication.getPrincipal();
            Map<String, String> jwtCookie = jwtUtils.generateJwtToken(userDetails.getUsername(), 36000);

            @SuppressWarnings("rawtypes")
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setStatus(HttpStatus.OK.value());
            loginResponse.setMessage("Authentification réussie.");
            loginResponse.setData(userDetails);

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.get("cookie"))
                    .body(loginResponse);

        } catch (BadCredentialsException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), new Date(), "Erreur",
                    "Nom d'utilisateur ou mot de passe incorrect.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), "Erreur", "Erreur interne du serveur.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {

        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), "Erreur",
                    MessageException.ACCOUNT_NAME_IS_BUSY);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), "Erreur",
                    MessageException.ACCOUNT_MAIL_IS_BUSY);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setEnabled(true);

        userRepository.save(newUser);

        return ResponseEntity.ok("Utilisateur enregistré avec succès !");
    }

    @PutMapping("disable/{username}")
    public ResponseEntity<?> disableUser(@PathVariable String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), "Erreur",
                    MessageException.USER_NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        User user = userOptional.get();
        user.setEnabled(false);
        userRepository.save(user);

        return ResponseEntity.ok("Compte désactivé avec succès.");
    }

    @PutMapping("enable/{username}")
    public ResponseEntity<?> enableUser(@PathVariable String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), "Erreur",
                    MessageException.USER_NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        User user = userOptional.get();
        user.setEnabled(true);
        userRepository.save(user);

        return ResponseEntity.ok("Compte activé avec succès.");
    }
}
