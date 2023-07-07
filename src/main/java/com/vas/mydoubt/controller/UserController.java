package com.vas.mydoubt.controller;

import com.vas.mydoubt.config.JWTUtil;
import com.vas.mydoubt.entity.MyUser;
import com.vas.mydoubt.model.UserRequest;
import com.vas.mydoubt.model.UserResponse;
import com.vas.mydoubt.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserRequest user) {

        String id = userService.saveUser(user);
        String message= "User with id '"+id+"' saved successfully!";
        return ResponseEntity.ok(message);

    }

    @GetMapping("/getData/{username}")
    public ResponseEntity<?> getData(@PathVariable String username){
       Optional<MyUser>  myUser;
       GetUserResponse userResponse;
        try{
            myUser = userService.findByUsername(username);
            if(myUser.isPresent()){
                userResponse = GetUserResponse.builder()
                        .id(myUser.get().getId())
                        .username(myUser.get().getUsername())
                        .email(myUser.get().getEmail())
                        .roles(myUser.get().getRoles())
                        .build();
                return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
            }

        }catch (UsernameNotFoundException exception){
            return new ResponseEntity<>(exception.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

}
