package com.abd.pet.application;

import com.abd.pet.atm.shared.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.abd.pet.*")
@EnableJpaRepositories("com.abd.pet.atm.ejb.repo")
@EntityScan("com.abd.pet.atm.ejb.*")
public class PetProjectsApplication {


    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home() {
        return customerService.get(1).toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(PetProjectsApplication.class, args);
    }
}
