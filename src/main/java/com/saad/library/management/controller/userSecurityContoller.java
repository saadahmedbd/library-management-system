package com.saad.library.management.controller;

import com.saad.library.management.model.security_User;
import com.saad.library.management.service.customUserDetilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class userSecurityContoller {

    @Autowired
    public customUserDetilsService customUserDetilsService;

    @PostMapping("/register")
    public security_User register (@RequestBody security_User securityUser){
        return customUserDetilsService.userRegister(securityUser);
    }
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody security_User securityUser){
        String response=customUserDetilsService.login(securityUser);
        if(response.equals("Invalid username and password") || response.equals("Login failed!")){
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

}
