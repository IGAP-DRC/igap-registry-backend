package com.igap.registry.dto.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Joe Monkila
 */


@Getter
@Setter
public class LoginDTO {
    private String username;
    private String password;
}
