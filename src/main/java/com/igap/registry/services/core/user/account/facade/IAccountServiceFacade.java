package com.igap.registry.services.core.user.account.facade;



import drc.hautesel.mariage.domain.core.user.account.Account;
import drc.hautesel.mariage.infrastructure.service.interfaces.IAddService;
import drc.hautesel.mariage.infrastructure.service.interfaces.IFindAllService;
import drc.hautesel.mariage.infrastructure.service.interfaces.IFindByIdService;
import drc.hautesel.mariage.infrastructure.service.interfaces.IUpdateService;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * class IAccountServiceFacade
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 Haute sel
 */
public abstract class IAccountServiceFacade implements IFindAllService<Account>, IFindByIdService<Account>, IAddService<Account>, IUpdateService<Account> {
    protected abstract void changePassword(@NonNull UUID id, @NonNull String oldPassword,@NonNull String newPassword);
    protected abstract Account currentAccount();
    protected abstract Boolean isExistByUsername(String username);
    protected abstract Boolean isExistByEmail(String email);
    protected abstract Account finByEmail(@NonNull String email);
    protected abstract Account login(Account account);
    protected abstract String getAccountNumber();
    protected abstract boolean usernameIsValid(String username);
    protected abstract boolean passwordIsValid(String password);
}
