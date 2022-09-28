package com.order.service;

import java.util.Optional;

import com.order.entities.LineItem;
import com.order.entities.Order;

public interface OrderService {
		
	public Order addOrder(LineItem item);
	
	public String deleteOrder(Integer OrderId);
	
	public String updateOrder(Integer OrderId, LineItem item);
	
	public Optional<Order> searchOrder(Integer OrderId);
	
	public String deleteLineItem(Integer itemId);
	
	public Optional<LineItem> searchItem(Integer OrderId);
	
	public String updateLineItem(Integer itemId, LineItem item);
}
