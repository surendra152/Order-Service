package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.dao.LineItemDao;
import com.order.dao.OrderDao;
import com.order.entities.LineItem;
import com.order.entities.Order;

@Service("OrderService")
public class OrderServiceImple implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private LineItemDao litemDao;

	@Override
	public Order addOrder(@RequestBody LineItem item) {
		Order order = new Order();
		item.setOrder(order);
		List<LineItem> obj = new ArrayList<LineItem>();
		obj.add(item);
		order.setItem(obj);

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
	public String updateOrder(Integer OrderId, LineItem item) {
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
	public Optional<LineItem> searchItem(Integer itemId) {
		Optional<LineItem> res = litemDao.findById(itemId);
		if (res.equals(Optional.empty()))
			return null;
		return res;
	}

	@Override
	public String updateLineItem(Integer itemId, LineItem item) {
		if (searchItem(itemId) == null)
			return null;
		else {
			litemDao.updateLineItem(itemId, item.getPrice(), item.getProductId(), item.getProductName(),
					item.getQuantity());
			return "Updated Successfully";
		}
	}

}
