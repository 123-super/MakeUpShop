package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.MyOrder;
import com.bean.Order;
import com.bean.OrderItem;
import com.dao.OrderMapper;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired 
	private OrderMapper ordermapper;
//	@Override
//	public void addOrder(Order order) {
//		ordermapper.addOrder(order);
//	}
//
//	@Override
//	public void addOrderItem(OrderItem orderitem) {
//		ordermapper.addOrderItem(orderitem);
//	}

	@Override
	public List<MyOrder> getMyOrder() {
		// TODO Auto-generated method stub
		return ordermapper.getMyOrder();
	}

	@Override
	public void addOrder(Order order, OrderItem orderitem) {
		// TODO Auto-generated method stub
		ordermapper.addOrder(order);
		orderitem.setOid(order.getId());
		ordermapper.addOrderItem(orderitem);
	}
	
//	@Override
//	public void addOrder(Order order, OrderItem orderitem) {
//		ordermapper.addOrder(order);
//		orderitem.setOid(order.getId());
//		ordermapper.addOrderItem(orderitem);
//	}

	@Override
	public void delCurrentOrder(Integer id) {
		ordermapper.delCurrentOrder1(id);
		ordermapper.delCurrentOrder2(id);
		
	}

	@Override
	public Order getOrderId(String orderNum) {
		// TODO Auto-generated method stub
		return ordermapper.getOrderId(orderNum);
	}

	@Override
	public void updateStatus(Integer id) {
		ordermapper.updateStatus(id);
		
	}

	@Override
	public List<MyOrder> getOrderUnPay() {
		// TODO Auto-generated method stub
		return ordermapper.getOrderUnPay();
	}

	@Override
	public List<MyOrder> getOrdersUnDeliver() {
		// TODO Auto-generated method stub
		return ordermapper.getOrdersUnDeliver();
	}
	@Override
	public List<MyOrder> getOrdersUnReceive() {
		// TODO Auto-generated method stub
		return ordermapper.getOrdersUnReceive();
	}
	@Override
	public List<MyOrder> getOrdersUnComment() {
		// TODO Auto-generated method stub
		return ordermapper.getOrdersUnComment();
	}
	@Override
	public void updLeftStatus(MyOrder order) {
		ordermapper.updLeftStatus(order);
		
	}

	


}
