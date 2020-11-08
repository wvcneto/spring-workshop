package com.wvcneto.springworkshop.services;

import com.wvcneto.springworkshop.entities.OrderItem;
import com.wvcneto.springworkshop.repositories.OrderItemRepository;
import com.wvcneto.springworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() { return orderItemRepository.findAll(); }

    public OrderItem findById(Long id) {
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);

        return orderItem.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
