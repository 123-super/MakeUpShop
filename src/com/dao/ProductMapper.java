package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductMapper {

	public List<Product> listProduct(Product product);

	public List<Product> getProductById(Integer id);

	public List<Product> searchProduct(String name);

	public int insertProduct(Product product);
	
	public int updateProduct(Product product);
	
	public int deleteProductById(Integer id);
}
