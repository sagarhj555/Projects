package com.Spring.JwtToken.controller;

import com.Spring.JwtToken.entity.User;
import com.Spring.JwtToken.repo.UserRepo;
import com.Spring.JwtToken.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringController {

    @Autowired UserRepo userRepo;
    @Autowired JwtService jwtService;
    @Autowired AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String hello() {
        return "Welcome to JWT example";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else return "enter correct user";
    }
}
