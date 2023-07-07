package com.vas.mydoubt.service;

import com.vas.mydoubt.entity.MyUser;
import com.vas.mydoubt.model.UserRequest;
import com.vas.mydoubt.repo.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String saveUser(UserRequest user) {
        //Encode password before saving to DB
        MyUser myUser = null;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        myUser = modelMapper.map(user , MyUser.class);

        String userId = UUID.randomUUID().toString();
        myUser.setId(userId);
        try{
            myUser = userRepository.save(myUser);
            return myUser.getId();
        }catch (Exception ex){
            log.error("Unable to save the user. : "+ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }

    }

    @Override
    public Optional<MyUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> obj = userRepository.findByUsername(username);
        org.springframework.security.core.userdetails.User springUser = null;

        if(obj.isPresent()){
            MyUser user = obj.get();
            Set<String> roles = user.getRoles();
            Set<GrantedAuthority> grantedAuthorityList = new HashSet();
            roles.stream().filter(role -> grantedAuthorityList.add(new SimpleGrantedAuthority(role))).collect(Collectors.toSet());

            springUser = new User(username,
                    user.getPassword(),
                    grantedAuthorityList);
        }
        return springUser;
    }
}
