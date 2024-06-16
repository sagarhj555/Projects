package com.example.SpringBootSecurity;

import com.example.SpringBootSecurity.dao.User;
import com.example.SpringBootSecurity.dao.UserPrincipal;
import com.example.SpringBootSecurity.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        return new UserPrincipal(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public String save(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return "user created";
    }
}
