package com.vas.mydoubt.service;

import com.vas.mydoubt.entity.MyUser;
import com.vas.mydoubt.model.UserRequest;

import java.util.Optional;

public interface IUserService {
    String saveUser(UserRequest user);
    Optional<MyUser> findByUsername(String username);

}
