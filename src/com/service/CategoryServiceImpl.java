package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Category;
import com.bean.Product;
import com.dao.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired 
	private CategoryMapper categorymapper;
	
	@Override	
	public List<Category> getCategory() {
		return categorymapper.getCategory(new Category());
	}

	@Override
	public List<Category> selectCategoryList(Category category) {
		return categorymapper.getCategory(category);
	}
	
	@Override
	public Category getCategoryById(Integer cid) {
		return categorymapper.getCategoryById(cid);
	}
	
	@Override	
	public List<Product> getProductByCid(Integer cid){
		return categorymapper.getProductByCid(cid);
	}
	@Override
	public List<Product> getProductByCidlimit(Integer cid) {
		// TODO Auto-generated method stub
		return categorymapper.getProductByCidlimit(cid);
	}
	@Override
	public List<Category> search(String seach) {
		// TODO Auto-generated method stub
		return categorymapper.search(seach);
	}
	@Override
	public void delCategoryById(Integer id) {
		categorymapper.delCategoryById(id);
		
	}
	@Override
	public void updCategoryById(Category category) {
		categorymapper.updCategoryById(category);
		
	}
	@Override
	public void addCategory(Category category) {
		categorymapper.addCategory(category);
		
	};
}
