package com.igap.registry.security.jwt.filter.facade;


import com.igap.registry.security.jwt.utils.JwtUtils;
import com.igap.registry.services.core.user.user.service.LoadUserByUsernameService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * class AuthTokenFilterFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Setter
@Getter
@Component
public class AuthTokenFilterFacade {


    private final JwtUtils jwtUtils;
    private final LoadUserByUsernameService accountDetailsService;

    public AuthTokenFilterFacade(JwtUtils jwtUtils, LoadUserByUsernameService accountDetailsService) {
        this.jwtUtils = jwtUtils;
        this.accountDetailsService = accountDetailsService;
    }

}
