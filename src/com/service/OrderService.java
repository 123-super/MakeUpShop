package com.service;

import java.util.List;

import com.bean.Comment;
import com.bean.MyOrder;
import com.bean.Order;
import com.bean.OrderItem;

public interface OrderService {
//	public void addOrder(Order order);
//	public void addOrderItem(OrderItem orderitem);
	public void addOrder(Order order,OrderItem orderitem);
	public List<Comment> getComment(Integer pid);
	public List<MyOrder> getMyOrder();
	public List<MyOrder> getOrderUnPay();
	public List<MyOrder> getOrdersUnDeliver();
	public List<MyOrder> getOrdersUnReceive();
	public List<MyOrder> getOrdersUnComment();
	public void delCurrentOrder(Integer id);
	public Order getOrderId(String orderNum);
	public void updateStatus(Integer id);
	public void updLeftStatus(MyOrder order);
	public void addComment(Comment comment);
	public void updOrderById(MyOrder order);
}
