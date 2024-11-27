package com.igap.registry.services.core.user.user.service;




import com.igap.registry.entities.core.user.User;
import com.igap.registry.repositories.user.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * class LoadUserByUsernameService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Service
public class LoadUserByUsernameService implements UserDetailsService {

    private final UserRepository dao;

    public LoadUserByUsernameService(UserRepository dao) {
        this.dao = dao;
    }

    @Override
    public User loadUserByUsername(@NonNull String username)  {
        return User.build(dao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)));
    }
}
