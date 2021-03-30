package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Category;
import com.bean.User;
import com.dao.UserMapper;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserMapper usermapper;
	@Override
	public List<User> checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return usermapper.checkUser(username, password);
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 usermapper.addUser(user);
	}
	@Override
	public List<User> searchUser(String seach) {
		// TODO Auto-generated method stub
		return usermapper.searchUser(seach);
	}
	@Override
	public void delUserById(Integer id) {
		usermapper.delUserById(id);
		
	}
	@Override
	public void updUserById(User user) {
		usermapper.updUserById(user);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return usermapper.getAllUser();
	}

}
