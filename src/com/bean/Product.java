package com.bean;

public class Product {

	private Integer id;
	private String name;
	private String brand;
	private Integer price;
	private String desc;
	private Integer cid;
	private Integer stocknum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getStocknum() {
		return stocknum;
	}

	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price +
				", desc=" + desc + ", cid=" + cid + ", stocknum=" + stocknum + "]";
	}

}
