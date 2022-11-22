package com.example.epptecrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/demo")
    public String demo() {
        return "Hello";
    }
}
