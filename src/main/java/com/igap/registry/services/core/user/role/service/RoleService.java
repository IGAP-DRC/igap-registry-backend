package com.igap.registry.services.core.user.role.service;


import com.igap.registry.entities.core.user.Role;
import com.igap.registry.entities.helpers.SlugEncoder;
import com.igap.registry.exceptions.ConflictException;
import com.igap.registry.exceptions.NotFoundException;
import com.igap.registry.helper.MessageException;
import com.igap.registry.services.core.user.role.facade.IRoleServiceFacade;
import com.igap.registry.services.core.user.role.facade.RoleServiceFacade;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;


/**
 * class RoleService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Service
public class RoleService extends IRoleServiceFacade {

    private final RoleServiceFacade facade;

    public RoleService(RoleServiceFacade facade) {
        this.facade = facade;
    }

    @Override
    public List<Role> find() {
        return facade.getDao().findAll();
    }

    @Override
    public Role findById(@NonNull UUID id) {
        return facade.getDao().findById(id).orElseThrow(()->new NotFoundException(MessageException.ROLE_NOT_FOUND));
    }



    @Override
    public Role add(@NonNull Role role) {

        Assert.notNull(role.getName(), MessageException.ROLE_NAME_IS_REQUIRED);
        Assert.isTrue(!role.getName().isEmpty(), MessageException.ROLE_NAME_IS_REQUIRED);

        if(isExistByName(role.getName())){
            throw new ConflictException(MessageException.ROLE_EXIST);
        }

        role.setSlug(SlugEncoder.encode(role.getName()));
        return facade.getDao().saveAndFlush(role);
    }

    @Override
    public Boolean isExistByName(@NonNull String name) {
        return facade.getDao().findByName(name).isPresent();
    }

    @Override
    public long count() {
        return facade.getDao().count();
    }
}
