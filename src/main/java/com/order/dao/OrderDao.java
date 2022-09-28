package com.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
