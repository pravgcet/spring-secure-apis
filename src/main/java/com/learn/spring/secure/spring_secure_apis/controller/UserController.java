package com.learn.spring.secure.spring_secure_apis.controller;

import com.learn.spring.secure.spring_secure_apis.dto.UserDto;
import com.learn.spring.secure.spring_secure_apis.entity.UserEntity;
import com.learn.spring.secure.spring_secure_apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto){
        UserEntity entity = new UserEntity();
        entity.setUserName(userDto.getUserName());
        entity.setPassword(passwordEncoder.encode(userDto.getPassword()));
        entity.setRoles(userDto.getRoles());
        return ResponseEntity.ok(userRepository.save(entity));
    }


}
