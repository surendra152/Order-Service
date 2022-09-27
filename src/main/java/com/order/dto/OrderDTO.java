package com.order.dto;

import java.util.List;

import com.order.entities.OrderLineItems;



public class OrderDTO {
	private List<OrderLineItems> orderLineItems;

	public OrderDTO(List<OrderLineItems> orderLineItems) {
		super();
		this.orderLineItems = orderLineItems;
	}

	public OrderDTO() {
	}

	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

}
