package com.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.Product;
import com.common.Result;
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
		return JSON.toJSONString(Result.success(product));		
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String search(String name){
		List<Product> product = productservice.searchProduct(name);
		return JSON.toJSONString(Result.success(product));
		
		
	}
	
	@RequestMapping(value = "/productImage/{pid}", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String productImage(@PathVariable String pid, HttpServletRequest request) {
		String rootPath = "/images/productDetail/" + pid;
		String realPath = request.getServletContext().getRealPath(rootPath);
		File file = new File(realPath);
		if (!file.exists()) {
			return JSON.toJSONString(Result.error());
		} else {
			String[] pathList = file.list();
			if (pathList.length > 0) {
				List<String> imgPathList = Arrays.asList(pathList).stream().map(item -> rootPath + "/" + item).collect(Collectors.toList());
				return JSON.toJSONString(Result.success(imgPathList));
			} else {
				return JSON.toJSONString(Result.error());
			}
		}
	}
}
