package com.service;

import java.util.List;

import com.bean.Product;
import com.bean.PropertyValue;

public interface ProductService {
	public List<Product> getProductById(Integer id);
	public List<Product> searchProduct(String name);
}
