package com.example.SpringBootSecurity;

import com.example.SpringBootSecurity.dao.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String hello(){
        return "Welcome to SpringBoot-Security";
    }

    @GetMapping("/sessionId")
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @Autowired SecurityService securityService;

    @GetMapping("/getAll")
    public List<User> users(){
        return securityService.findAll();
    }

    @PostMapping("/register")
    public String saveUser(@RequestBody User user){
        return securityService.save(user);
    }
}
