package com.wvcneto.springworkshop.services;

import com.wvcneto.springworkshop.entities.Order;
import com.wvcneto.springworkshop.repositories.OrderRepository;
import com.wvcneto.springworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){ return orderRepository.findAll(); }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        return order.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
