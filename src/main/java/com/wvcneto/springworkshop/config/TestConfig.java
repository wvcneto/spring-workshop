package com.wvcneto.springworkshop.config;

import com.wvcneto.springworkshop.entities.Category;
import com.wvcneto.springworkshop.entities.Order;
import com.wvcneto.springworkshop.entities.Product;
import com.wvcneto.springworkshop.entities.User;
import com.wvcneto.springworkshop.entities.enums.OrderStatus;
import com.wvcneto.springworkshop.repositories.CategoryRepository;
import com.wvcneto.springworkshop.repositories.OrderRepository;
import com.wvcneto.springworkshop.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Joe Snow", "joe@example.com", "912345678", "123456");
        User user2 = new User(null, "Mary Rose", "mrose@example.com", "912345678", "123456");

        Order order1 = new Order(null, Instant.parse("2020-06-20T19:53:07Z"), user1, OrderStatus.PAID);
        Order order2 = new Order(null, Instant.parse("2020-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
    }
}

