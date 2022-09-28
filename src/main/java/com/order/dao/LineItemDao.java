package com.order.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.order.entities.LineItem;

public interface LineItemDao extends JpaRepository<LineItem, Integer> {

	
	@Transactional
	@Modifying
	@Query("update LineItem set price= :price, product_id= :productId, product_name= :productName, quantity =:quantity where id = :itemId")

	int updateLineItem(@Param("itemId") Integer itemId, @Param("price") Double price,
			@Param("productId") Integer productId, @Param("productName") String productName,
			@Param("quantity") Integer quantity);
	
	
}
