package com.igap.registry.dto.auth.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Joe Monkila
 */


@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}
