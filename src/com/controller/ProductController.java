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
import com.bean.PropertyValue;
import com.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productservice;
	@RequestMapping(value = "/getProductById", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getProductById(Integer id){
		List<Product> product = productservice.getProductById(id);
		System.out.println(product);
		return JSON.toJSONString(product);
		
		
	}
	
}
