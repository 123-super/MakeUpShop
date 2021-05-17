package com.bean;

public class MyOrder {
	private String createDate;
	private String orderNum;
	private String status;
	private Integer number;
	private Integer price;
	private Integer id;
	private Integer pid;
	private Integer uid;
	private String receiverName;
	private String tel;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;


public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @Override
	public String toString() {
		return "MyOrder [createDate=" + createDate + ", orderNum=" + orderNum + ", status=" + status + ", number="
				+ number + ", price=" + price + ", id=" + id + ", pid=" + pid + ", uid=" + uid + ", name=" + name + "]";
	}
	public MyOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
}
