package com.sum.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class HomeController {

    @GetMapping("/api/welcome")
    public String welcome(){
        return "Welcome OAuth2 user";
    }

    @GetMapping("token")
    public Jwt getToken(@AuthenticationPrincipal Jwt jwt){
        return jwt;
    }

    @Secured("ROLE_developer")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable String id){
        return "User deleted with id: "+ id;
    }
}
