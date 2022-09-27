package com.order.entities;


import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

@Entity
@Table(name = "order_items")
public class OrderLineItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="product_id")
	private String productId;
	@Column(name="product_name")
	private String prodName;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="qty")
	private int qty;
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="order_id")
//	@Parent
	private Order order;

	public OrderLineItems() {
		super();
	}

	public OrderLineItems(String productId, String prodName, BigDecimal price, int qty, Order order) {
		super();
		this.productId = productId;
		this.prodName = prodName;
		this.price = price;
		this.qty = qty;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderLineItems [id=" + id + ", productId=" + productId + ", prodName=" + prodName + ", price=" + price
				+ ", qty=" + qty + "]";
	}


}
