package com.abd.pet.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.abd.pet.*")
@EnableJpaRepositories("com.abd.pet.atm.ejb.repo")
@EntityScan("com.abd.pet.atm.ejb.*")
@EnableMethodSecurity(securedEnabled = true)
public class PetProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetProjectsApplication.class, args);
    }
}
