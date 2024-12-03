package com.igap.registry.controllers.auth;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igap.registry.dto.auth.LoginDTO;
import com.igap.registry.dto.utils.ErrorResponse;
import com.igap.registry.security.jwt.utils.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/accounts/")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ErrorResponse errorResponse;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    User user;

    @PostMapping("signin")
    public ResponseEntity<?> authenticateUser(LoginDTO loginDTO) {


        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                        loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User userDetails = (User) authentication.getPrincipal();
        Map<String, String> jwtCookie = jwtUtils.generateJwtToken(userDetails.getUsername(), 36000);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        if (userDetails.getUsername() == null) {
            errorResponse.setStatusCode(400);
            errorResponse.setMessage(loginDTO.getUsername()+ "N'existe pas");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // statusResponse.setStatus(200);
        // statusResponse.setMessage("Authentification reussie");
        // statusResponse.setData(new UserInfoResponse(userDetails.getId(),
        //         userDetails.getUsername(),
        //         userDetails.getEmail(),
        //         userDetails.getStatus(),
        //         roles, jwtCookie.getValue(), userDetails.getProfil(), userDetails.getPhone()));

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(null);
    }
}
