package com.igap.registry.security.jwt.handler;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * class CustomAuthenticationFailureHandler
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.err.println("Nom d'utilisateur ou mot de passe incorrect");
        if (exception.getMessage().equalsIgnoreCase("Bad credentials")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Nom d'utilisateur ou mot de passe incorrect.");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Échec de l'authentification : " + exception.getMessage());
        }
    }

}
