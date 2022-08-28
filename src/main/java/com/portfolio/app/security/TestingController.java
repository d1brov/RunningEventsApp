package com.portfolio.app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestingController {

    @GetMapping("open")
    String open() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + " " + authentication.getAuthorities();
    }

    @GetMapping("admin")
    String admin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + " " + authentication.getAuthorities();
    }

    @GetMapping("user")
    String user() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName() + " " + authentication.getAuthorities();
    }
}
