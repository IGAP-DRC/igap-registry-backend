package com.igap.registry.services.core.user.user.service;


import com.igap.registry.entities.core.user.User;
import com.igap.registry.entities.helpers.SlugEncoder;
import com.igap.registry.exceptions.BadRequestException;
import com.igap.registry.exceptions.ConflictException;
import com.igap.registry.exceptions.NotFoundException;
import com.igap.registry.helper.MessageException;
import com.igap.registry.helper.Security;
import com.igap.registry.services.core.user.user.facade.IUserServiceFacade;
import com.igap.registry.services.core.user.user.facade.UserServiceFacade;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * class UserService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Service
public class UserService extends IUserServiceFacade {

    private final UserServiceFacade facade;
    public UserService(UserServiceFacade facade) {
        this.facade = facade;
    }


    @Override
    public List<User> find() {
        return facade.getDao().findAll();
    }

    @Override
    public User findById(UUID id) {
        return facade.getDao().findById(id).orElseThrow(()-> new NotFoundException(MessageException.ACCOUNT_NOT_FOUND));
    }


    @Override
    @Transactional
    public User add(@NonNull User user)  {

        if(user.getRoles().isEmpty()){
            throw new BadRequestException(MessageException.ROLE_IS_REQUIRED);
        }

        if(!StringUtils.hasText(user.getUsername())){
            throw new BadRequestException(MessageException.ACCOUNT_USERNAME_IS_REQUIRED);
        }

        if(!StringUtils.hasText(user.getPassword())){
            throw new BadRequestException(MessageException.ACCOUNT_PASSWORD_IS_REQUIRED);
        }

        if(!StringUtils.hasText(user.getEmail())){
            throw new BadRequestException(MessageException.ACCOUNT_MAIL_IS_NOT_NULL);
        }

        if(usernameIsValid(user.getUsername())){
            throw new BadRequestException(MessageException.ACCOUNT_USERNAME_NOT_VALID);
        }

        if(EmailValidator.getInstance().isValid(user.getEmail())){
            throw new BadRequestException(MessageException.MAIL_NOT_VALID);
        }

        if(isExistByUsername(user.getUsername())){
            throw new ConflictException(MessageException.ACCOUNT_NAME_IS_BUSY);
        }

        if(isExistByEmail(user.getEmail())){
            throw new ConflictException(MessageException.ACCOUNT_MAIL_IS_BUSY);
        }
/*
        user.getRoles().forEach(
                role -> {

                }
        );
        user.setRole(facade.getRoleService().findById(user.getRole().getId()));
*/
        user.setPassword(facade.getEncoder().encode(user.getPassword()));
        user.setEnabled(Boolean.TRUE);
        user.setCreatedBy(currentAccount().getId());
        user.setSlug(SlugEncoder.encode(user.getUsername()));

        return facade.getDao().saveAndFlush(user);
    }

    public void resendCode(String email){
        if(!isExistByEmail(email)){
            throw new BadRequestException(MessageException.ACCOUNT_NOT_FOUND);
        }
    }

    @Override
    public Boolean isExistByUsername(@NonNull String username) {
        return facade.getDao().findByUsername(username).isPresent();
    }

    @Override
    public Boolean isExistByEmail(@NonNull String email) {
        return facade.getDao().findByEmail(email).isPresent();
    }

    @Override
    public User finByEmail(@NonNull String email) {
        return facade.getDao().findByEmail(email).orElseThrow(() -> new NotFoundException(MessageException.ACCOUNT_NOT_FOUND));
    }

    @Override
    public User login(@NonNull User user){

        Authentication authentication = facade.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String token = "";

        if(authentication.isAuthenticated()) {
            token = facade.getJwtUtils().generateJwtToken(user.getUsername(), System.currentTimeMillis() + 300 * 600 * 10000).get(Security.BEAR);
        }

        user = (User) authentication.getPrincipal();
        user = findById(user.getId());
        user.setToken(token);
        return user;
    }

    @Override
    public void changePassword(@NonNull UUID id, @NonNull String oldPassword,@NonNull String newPassword){
        User update = findById(id);

        if(!StringUtils.hasText(oldPassword) || !StringUtils.hasText(oldPassword)){
            throw new BadRequestException(MessageException.ACCOUNT_PASSWORD_IS_REQUIRED);
        }

        if(!facade.getEncoder().matches(oldPassword, update.getPassword())){
            throw new BadRequestException(MessageException.ACCOUNT_PASSWORD_INCORRECT_IS_REQUIRED);
        }
        if(!passwordIsValid(newPassword)){
            throw new BadRequestException(MessageException.ACCOUNT_PASSWORD_NOT_VALID);
        }
        update.setPassword(facade.getEncoder().encode(newPassword));;
        facade.getDao().saveAndFlush(update);
    }

    @Override
    public User update(@NonNull UUID id,@NonNull User user) {
        User update = findById(id);

        if(Objects.nonNull(user.getUsername()) && !update.getUsername().equals(user.getUsername())){
            if(isExistByUsername(user.getUsername())){
                throw new ConflictException(MessageException.ACCOUNT_NAME_IS_BUSY);
            }
            update.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getEmail()) && !update.getEmail().equals(user.getEmail())){
            if(isExistByEmail(user.getEmail())){
                throw new ConflictException(MessageException.ACCOUNT_MAIL_IS_BUSY);
            }
            Assert.isTrue(EmailValidator.getInstance().isValid(user.getEmail()), MessageException.MAIL_NOT_VALID);
            update.setEmail(user.getEmail());
        }

        if(user.isEnabled()){
            update.setEnabled(user.isEnabled());
        }


        update.setUpdatedAt(LocalDateTime.now());
        update.setUpdatedBy(currentAccount().getId());
        return facade.getDao().saveAndFlush(update);
    }




    @Override
    public User currentAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user;
        try {
            if (authentication != null && authentication.isAuthenticated()) {
                user = facade.getLoadUserByUsernameService().loadUserByUsername(authentication.getName());
            } else {
                throw new NotFoundException(MessageException.NOT_CURRENT_SESSION);
            }
        }catch (Exception exception){
            throw new NotFoundException(MessageException.NOT_CURRENT_SESSION);
        }

        return user;
    }

    @Override
    public boolean usernameIsValid(String username) {
        return Objects.nonNull(username) && username.length() >= 4 && !username.contains(" ");
    }

    @Override
    public boolean passwordIsValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$");
    }

    public User findByUsername(String username){
        return facade.getDao().findByUsername(username).orElseThrow(()->new NotFoundException(MessageException.USER_NOT_FOUND));
    }

}
