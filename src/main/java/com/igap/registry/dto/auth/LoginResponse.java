package com.igap.registry.dto.auth;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private UUID id;
    private String username;
    private String email;
    private Boolean enabled;
    private List<String> roles;
    private String token;
}
