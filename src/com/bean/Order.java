package com.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
private Integer id;
private Integer uid;
private String orderNum;
private String address;
private String postNum;
private String receiverName;
private String tel;
private String status; 

private String createDate;

private Timestamp payDate;
private Timestamp deliveryDate;
private Timestamp confirmDate;

public void setCreateDate(String createDate) {
	this.createDate = createDate;
}

public String getCreateDate() {
	return createDate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getOrderNum() {
	return orderNum;
}
public void setOrderNum(String orderNum) {
	this.orderNum = orderNum;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPostNum() {
	return postNum;
}
public void setPostNum(String postNum) {
	this.postNum = postNum;
}
public String getReceiverName() {
	return receiverName;
}
public void setReceiverName(String receiverName) {
	this.receiverName = receiverName;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}


public Timestamp getPayDate() {
	return payDate;
}
public void setPayDate(Timestamp payDate) {
	this.payDate = payDate;
}
public Timestamp getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(Timestamp deliveryDate) {
	this.deliveryDate = deliveryDate;
}
public Timestamp getConfirmDate() {
	return confirmDate;
}
public void setConfirmDate(Timestamp confirmDate) {
	this.confirmDate = confirmDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
}
