package com.igap.registry.services.core.user.user.facade;



import com.igap.registry.repositories.user.UserRepository;
import com.igap.registry.security.jwt.utils.JwtUtils;
import com.igap.registry.services.core.user.role.service.RoleService;
import com.igap.registry.services.core.user.user.service.LoadUserByUsernameService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * class UserServiceFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Getter
@Setter
@Component
public class UserServiceFacade {

    private final UserRepository dao;
    private final LoadUserByUsernameService loadUserByUsernameService;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;




    public UserServiceFacade(UserRepository dao, LoadUserByUsernameService loadUserByUsernameService,
                             BCryptPasswordEncoder encoder, RoleService roleService,
                             AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.dao = dao;
        this.loadUserByUsernameService = loadUserByUsernameService;
        this.encoder = encoder;
        this.roleService = roleService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }
}
