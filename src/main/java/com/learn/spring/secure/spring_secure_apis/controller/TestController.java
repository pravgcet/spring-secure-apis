package com.learn.spring.secure.spring_secure_apis.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/hello")
    public ResponseEntity<String> getHi(){
        return ResponseEntity.ok("Hi");
    }

    @GetMapping("/resource")
    public ResponseEntity<String> getResource(){
        return ResponseEntity.ok("This is data");
    }

}
