package com.dao;


import java.util.List;

import com.bean.MyOrder;
import com.bean.Order;
import com.bean.OrderItem;


public interface OrderMapper {
	public void addOrder(Order order);
	public void addOrderItem(OrderItem orderitem);
//	public void addorder(Order order,OrderItem orderItem);
	public List<MyOrder> getMyOrder();
	public List<MyOrder> getOrderUnPay();
	public List<MyOrder> getOrdersUnDeliver();
	public List<MyOrder> getOrdersUnReceive();
	public List<MyOrder> getOrdersUnComment();
	public void delCurrentOrder1(Integer id);
	public void delCurrentOrder2(Integer id);
	public Order getOrderId(String orderNum);
	public void updateStatus(Integer id);
	public void updLeftStatus(MyOrder order);
}