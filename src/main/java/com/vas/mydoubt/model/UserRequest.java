package com.vas.mydoubt.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserRequest {

    private String username;
    private String password;
    private String email;
    private Set<String> roles;

}
