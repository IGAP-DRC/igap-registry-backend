package com.igap.registry.services.core.user.role.facade;



import com.igap.registry.repositories.user.RoleRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * class RoleServiceFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
@Component
public class RoleServiceFacade {

    private final RoleRepository dao;

    public RoleServiceFacade(RoleRepository dao) {
        this.dao = dao;
    }
}
