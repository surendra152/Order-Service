package com.order.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="`id`")
	private int id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order",
			orphanRemoval = true)
	private List<OrderLineItems> orderLineItems;
	
	
	public Order() {
		super();
	}
	
	
	public Order(String name) {
		super();
		this.name = name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


//	@Override
//	public String toString() {
//		return "Order [id=" + id + ", orderLineItems=" + orderLineItems + "]";
//	}
	
	
	
	
	

}
