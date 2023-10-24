package com.abd.pet.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @GetMapping("/")
    public String startPage() {
        return " Hello. This is Pet Project.";
    }
}
