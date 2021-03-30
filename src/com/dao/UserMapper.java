package com.dao;

import java.util.List;

import com.bean.User;

public interface UserMapper {
	public List<User> checkUser(String username,String password);
	public void addUser(User user);
	public List<User> searchUser(String seach);
	public void delUserById(Integer id);
	public void updUserById(User user);
	public List<User> getAllUser();
}
