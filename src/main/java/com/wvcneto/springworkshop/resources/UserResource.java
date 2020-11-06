package com.wvcneto.springworkshop.resources;

import com.wvcneto.springworkshop.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Joe","joe@example.com", "123456789", "123456");

        return ResponseEntity.ok().body(user);
    }
}
