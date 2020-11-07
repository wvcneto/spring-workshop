package com.wvcneto.springworkshop.config;

import com.wvcneto.springworkshop.entities.User;
import com.wvcneto.springworkshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joe Snow", "joe@example.com", "912345678", "123456");
        User user2 = new User(null, "Mary Rose", "mrose@example.com", "912345678", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}

