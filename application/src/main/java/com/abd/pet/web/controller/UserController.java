package com.abd.pet.web.controller;

import com.abd.pet.atm.shared.model.Role;
import jakarta.websocket.server.PathParam;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.abd.pet.atm.shared.model.Role.USER_MGMT;

@RestController
public class UserController {

    @Secured({"USER_MGMT"})
    @GetMapping("/users")
    public String startPage() {
        return "This is Users page.";
    }

    @GetMapping("/users/:id")
    public String getUsers(@PathParam("id") long id) {
        return "This is User with id=" + id + ".";
    }
    @GetMapping("/users/:id/accounts")
    public String getAccounts(@PathParam("id") long id) {
        return "This is User with id=" + id + " accounts.";
    }
}
