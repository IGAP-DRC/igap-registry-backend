package com.igap.registry.services.core.user.role.facade;





import com.igap.registry.entities.core.user.Role;
import com.igap.registry.services.interfaces.IAddService;
import com.igap.registry.services.interfaces.ICountService;
import com.igap.registry.services.interfaces.IFindAllService;
import com.igap.registry.services.interfaces.IFindByIdService;
import org.springframework.lang.NonNull;


/**
 * class IRoleServiceFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public abstract class IRoleServiceFacade implements IFindAllService<Role>, IFindByIdService<Role>, IAddService<Role>, ICountService {
    protected abstract Boolean isExistByName(@NonNull String name);
    protected abstract Role findBySlug(String name);
}
