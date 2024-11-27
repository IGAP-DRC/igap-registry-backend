package com.igap.registry.services.core.user.user.facade;



import com.igap.registry.entities.core.user.User;
import com.igap.registry.services.interfaces.IAddService;
import com.igap.registry.services.interfaces.IFindAllService;
import com.igap.registry.services.interfaces.IFindByIdService;
import com.igap.registry.services.interfaces.IUpdateService;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * class IUserServiceFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
public abstract class IUserServiceFacade implements IFindAllService<User>, IFindByIdService<User>, IAddService<User>, IUpdateService<User> {
    protected abstract void changePassword(@NonNull UUID id, @NonNull String oldPassword,@NonNull String newPassword);
    protected abstract User currentAccount();
    protected abstract Boolean isExistByUsername(String username);
    protected abstract Boolean isExistByEmail(String email);
    protected abstract User finByEmail(@NonNull String email);
    protected abstract User login(User account);
    protected abstract boolean usernameIsValid(String username);
    protected abstract boolean passwordIsValid(String password);
}
