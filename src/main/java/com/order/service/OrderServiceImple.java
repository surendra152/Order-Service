package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.repo.ItemRepo;
import com.order.repo.OrderRepo;
import com.order.entities.Order;
import com.order.entities.OrderLineItems;

@Service("OrderService")
public class OrderServiceImple implements OrderService {

	@Autowired
	private OrderRepo orderDao;

	@Autowired
	private ItemRepo litemDao;

	@Override
	public Order addOrder(OrderLineItems item) {
		Order order = new Order();
		//item.setOrder(order);
		List<OrderLineItems> obj = new ArrayList<OrderLineItems>();
		obj.add(item);
		order.setOrderLineItems(obj);

		return orderDao.save(order);

	}

	@Override
	public String deleteOrder(Integer cartId) {

		if (searchOrder(cartId) == null)
			return "Invalid Id";
		orderDao.deleteById(cartId);
		return "Deleted Successfully";
	}

	@Override
	
	public String updateOrder(Integer OrderId, OrderLineItems item) {
		if (searchOrder(OrderId) == null)
			return "Invalid Id";
		item.setOrder(orderDao.getById(OrderId));
		litemDao.save(item);
		return "Updated Successfully";
	}

	@Override
	public Optional<Order> searchOrder(Integer OrderId) {
		Optional<Order> res = orderDao.findById(OrderId);
		if (res.equals(Optional.empty()))
			return null;
		return res;
	}

	// LineItemServices

	@Override
	public String deleteLineItem(Integer itemId) {
		if (searchItem(itemId) == null)
			return "Invalid Id";
		else {
			litemDao.deleteById(itemId);
			return "Deleted Successfully";
		}
	}

	@Override
	public Optional<OrderLineItems> searchItem(Integer itemId) {
		Optional<OrderLineItems> res = litemDao.findById(itemId);
		if (res.equals(Optional.empty()))
			return null;
		return res;
	}

	@Override
	public String updateLineItem(Integer itemId, OrderLineItems item) {
		if (searchItem(itemId) == null)
			return null;
		else {
			litemDao.updateLineItem(itemId, item.getPrice(), item.getProductId(), item.getProdName(),
					item.getQty());
			return "Updated Successfully";
		}
	}

}
