package com.order.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Order {
	@Id
	@GeneratedValue
	private int orderid;
	
	@OneToMany(targetEntity = LineItem.class,cascade = CascadeType.ALL)
	@JoinColumn(name="orderid")
	private List<LineItem> item;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public List<LineItem> getItem() {
		return item;
	}

	public void setItem(List<LineItem> item) {
		this.item = item;
	}
	
	
	
}



