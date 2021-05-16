package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.Category;
import com.bean.User;
import com.common.Constant;
import com.common.Result;
import com.common.TokenService;
import com.service.UserService;
import com.utils.ResponseObj;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value = "/getUserByToken", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getUserByToken(String token) {
		User user = Constant.TOKEN_MAP.get(token);
		return JSON.toJSONString(Result.success(user));
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String login(String username, String password) {
		List<User> users = userservice.checkUser(username, password);
		if(users.size() > 0) {
			User user = users.get(0);
			Constant.TOKEN_MAP.put(tokenService.createToken(user), user);
			System.out.println(JSON.toJSONString(Result.success(user)));
			System.out.println(user);
			System.out.println(Result.success(user));
			return JSON.toJSONString(Result.success(user));
		}else {
			return JSON.toJSONString(Result.error());
		}
		
	}
	
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void addUser(User user) {
			userservice.addUser(user);		
		}
	
	@RequestMapping(value = "/searchUser", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String searchUser(String search) {
		List<User> s=userservice.searchUser(search);
		return JSON.toJSONString(Result.success(s));
	}
	
	@RequestMapping(value = "/delUserById", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void delUserById(Integer id) {
		userservice.delUserById(id);
	}
	
	@RequestMapping(value = "/updUserById", method = RequestMethod.POST, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public void updUserById(User user)  {
		userservice.updUserById(user);
	}
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/json;charsest=utf-8")
	@ResponseBody
	public String getAllUser()  {
		List<User> u=userservice.getAllUser();
		return JSON.toJSONString(Result.success(u));
	}


}
