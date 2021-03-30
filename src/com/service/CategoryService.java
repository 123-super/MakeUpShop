package com.service;

import java.util.List;

import com.bean.Category;
import com.bean.Product;

public interface CategoryService {
	public List<Category> getCategory();
	public List<Product> getProductByCid(Integer cid);
	public List<Product> getProductByCidlimit(Integer cid);
	public List<Category> search(String seach);
	public void delCategoryById(Integer id);
	public void updCategoryById(Category category);
	public void addCategory(Category category);
}
