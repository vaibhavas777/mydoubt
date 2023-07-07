package com.vas.mydoubt.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserResponse {

    private String id;
    private String username;
    private String email;
    private Set<String> roles;
}
