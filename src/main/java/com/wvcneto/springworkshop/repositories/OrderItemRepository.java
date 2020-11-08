package com.wvcneto.springworkshop.repositories;

import com.wvcneto.springworkshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
