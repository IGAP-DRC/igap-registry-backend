package com.igap.registry.controllers.auth;

import com.igap.registry.dto.auth.request.LoginRequest;
import com.igap.registry.dto.auth.request.RegisterRequest;
import com.igap.registry.dto.auth.response.LoginResponse;
import com.igap.registry.dto.utils.ErrorResponse;
import com.igap.registry.entities.core.user.User;
import com.igap.registry.repositories.user.UserRepository;
import com.igap.registry.security.jwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/accounts/")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
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

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setStatus(200);
            loginResponse.setMessage("Authentification réussie.");
            loginResponse.setData(userDetails);

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.get("cookie"))
                    .body(loginResponse);

        } catch (BadCredentialsException e) {
            ErrorResponse errorResponse = new ErrorResponse(401, new Date(), "Erreur",
                    "Nom d'utilisateur ou mot de passe incorrect.");
            return ResponseEntity.status(401).body(errorResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(500, new Date(), "Erreur", "Erreur interne du serveur.");
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {

        if (userRepository.findByUsername(registerRequest.getUsername()) != null) {
            ErrorResponse errorResponse = new ErrorResponse(400, new Date(), "Erreur",
                    "Le nom d'utilisateur est déjà pris.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        if (userRepository.findByEmail(registerRequest.getEmail()) != null) {
            ErrorResponse errorResponse = new ErrorResponse(400, new Date(), "Erreur",
                    "L'adresse e-mail est déjà utilisée.");
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
}
