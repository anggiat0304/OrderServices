package com.anggiat.OrderService.repository;

import com.anggiat.OrderService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order , Long> {

}
