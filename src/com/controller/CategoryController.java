package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.Category;
import com.bean.Product;
import com.common.Result;
import com.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;
	
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getCategory(Category category) {
		List<Category> categoryList = categoryservice.selectCategoryList(category);
		System.out.print(category+"+++++++++++++");
		return JSON.toJSONString(Result.success(categoryList));
	}
	
	@RequestMapping(value = "/getCategoryById", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getCategoryById(Integer cid) {
		Category category = categoryservice.getCategoryById(cid);
		System.out.print(category+"+++++++++++++");
		return JSON.toJSONString(Result.success(category));
	}
	
	
	@RequestMapping(value = "/getProductByCid", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getProductByCid(Integer cid) {
		List<Product> product = categoryservice.getProductByCid(cid);
		System.out.print(product+"+++++++++++++");
		return JSON.toJSONString(Result.success(product));
	}
	
	
	@RequestMapping(value = "/getProductByCidlimit", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getProductByCidlimit(Integer cid) {
		List<Product> product1 = categoryservice.getProductByCidlimit(cid);
		System.out.print(product1+"+++++++++++++");
		return JSON.toJSONString(Result.success(product1));
	}
	
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String search(String search) {
		List<Category> s=categoryservice.search(search);
		return JSON.toJSONString(Result.success(s));
	}
	
	@RequestMapping(value = "/delCategoryById", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void delCategoryById(Integer id) {
		categoryservice.delCategoryById(id);
	}
	
	@RequestMapping(value = "/updCategoryById", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void updCategoryById(Category category)  {
		categoryservice.updCategoryById(category);;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void addCategory(Category category) {
		categoryservice.addCategory(category);
	}
}
	
