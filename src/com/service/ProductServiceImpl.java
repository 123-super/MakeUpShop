package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.bean.PropertyValue;
import com.dao.ProductMapper;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired 
	private ProductMapper productmapper;
	
	@Override
	public List<Product> listProduct(Product product) {
		return productmapper.listProduct(product); 
	}
	
	@Override	
	public List<Product> getProductById(Integer id){
		return productmapper.getProductById(id);
	}
	@Override
	public List<Product> searchProduct(String name) {
		// TODO Auto-generated method stub
		return productmapper.searchProduct(name);
	}
	
	@Override
	public int insertProduct(Product product) {
		return productmapper.insertProduct(product);
	}
	
	@Override
	public int updateProduct(Product product) {
		return productmapper.updateProduct(product);
	}

	@Override
	public int deleteProductById(Integer id) {
		return productmapper.deleteProductById(id);
	}
}
