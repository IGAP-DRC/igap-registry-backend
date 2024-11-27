package com.igap.registry.security.config.facade;


import com.igap.registry.security.jwt.filter.filter.AuthTokenFilter;
import com.igap.registry.services.core.user.user.service.LoadUserByUsernameService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * class SecurityConfigFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Getter
@Setter
@Configuration
@EnableWebSecurity
public class SecurityConfigFacade {

    private final LoadUserByUsernameService loadUserByUsernameService;
    private final AuthTokenFilter authTokenFilter;

    public SecurityConfigFacade( LoadUserByUsernameService loadUserByUsernameService, AuthTokenFilter authTokenFilter) {
        this.loadUserByUsernameService = loadUserByUsernameService;
        this.authTokenFilter = authTokenFilter;
    }
}
