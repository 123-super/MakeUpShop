package com.dao;

import java.util.List;

import com.bean.Category;
import com.bean.Product;

public interface CategoryMapper {
public List<Category> getCategory(Category category);
public Category getCategoryById(Integer cid);
public List<Product> getProductByCid(Integer cid);
public List<Product> getProductByCidlimit(Integer cid);
public List<Category> search(String seach);
public void delCategoryById(Integer id);
public void updCategoryById(Category category);
public void addCategory(Category category);
}
