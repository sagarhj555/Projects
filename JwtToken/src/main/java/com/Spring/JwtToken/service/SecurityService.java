package com.Spring.JwtToken.service;

import com.Spring.JwtToken.entity.User;
import com.Spring.JwtToken.entity.UserPrincipal;
import com.Spring.JwtToken.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user != null) {
            return new UserPrincipal(user);
        } else throw new UsernameNotFoundException("Send Correct User");
    }
}
