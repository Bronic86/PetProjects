package com.abd.pet.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.abd.pet")
@RestController
public class PetProjectsApplication {


    public PetProjectsApplication() {
    }

    @GetMapping("/")
    public String home() {
        return "Hello Pets!";
    }

    public static void main(String[] args) {
        SpringApplication.run(PetProjectsApplication.class, args);
    }
}
