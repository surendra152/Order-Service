package com.order.service;

import java.util.Optional;

import com.order.entities.Order;
import com.order.entities.OrderLineItems;

public interface OrderService {
		
	public Order addOrder(OrderLineItems item);
	
	public String deleteOrder(Integer OrderId);
	
	public String updateOrder(Integer OrderId, OrderLineItems item);
	
	public Optional<Order> searchOrder(Integer OrderId);
	
	public String deleteLineItem(Integer itemId);
	
	public Optional<OrderLineItems> searchItem(Integer OrderId);
	
	public String updateLineItem(Integer itemId, OrderLineItems item);
}
