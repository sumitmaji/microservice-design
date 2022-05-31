package com.sum.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HomeController {

    @GetMapping("/api/welcome")
    public String welcome(){
        return "Welcome OAuth2 user";
    }
}
