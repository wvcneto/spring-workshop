package com.wvcneto.springworkshop.config;

import com.wvcneto.springworkshop.entities.Category;
import com.wvcneto.springworkshop.entities.Order;
import com.wvcneto.springworkshop.entities.User;
import com.wvcneto.springworkshop.entities.enums.OrderStatus;
import com.wvcneto.springworkshop.repositories.CategoryRepository;
import com.wvcneto.springworkshop.repositories.OrderRepository;
import com.wvcneto.springworkshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joe Snow", "joe@example.com", "912345678", "123456");
        User user2 = new User(null, "Mary Rose", "mrose@example.com", "912345678", "123456");

        Order order1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}

