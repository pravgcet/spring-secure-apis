package com.learn.spring.secure.spring_secure_apis.service;

import com.learn.spring.secure.spring_secure_apis.entity.UserEntity;
import com.learn.spring.secure.spring_secure_apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUserName(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Invalid User");
        }
        return User
                .builder()
                .username(user.get().getUserName())
                .password(user.get().getPassword())
                .roles(user.get().getRoles().toArray(String[]::new))
                .build();
    }
}
