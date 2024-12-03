package com.igap.registry.dto.auth.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Joe Monkila
 */

@Getter
@Setter
public class RegisterRequest {

    
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
