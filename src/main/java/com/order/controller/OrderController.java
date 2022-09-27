package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.OrderDTO;
import com.order.entities.Order;
import com.order.entities.OrderLineItems;
import com.order.repo.OrderRepo;



@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderRepo orderRepo;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrderLineItems(orderDTO.getOrderLineItems());
		for(OrderLineItems item : orderDTO.getOrderLineItems()) {
			item.setOrder(order);
		}
		orderRepo.save(order);
		
		return "Order placed!";
		
	}

}
