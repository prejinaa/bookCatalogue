package com.example.bookCatalogue.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")


    public class UserController {


    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello Admin";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello user";

    }
}
