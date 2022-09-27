package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.Order;



public interface OrderRepo extends JpaRepository<Order, Integer> {

}
