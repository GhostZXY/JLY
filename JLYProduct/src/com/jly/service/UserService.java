package com.jly.service;
import java.util.List;

import com.jly.bean.User;

public interface UserService {
	public List<User> findAllUser();
	public User findUserById(int id);
	public boolean addUser(User user);
	public boolean login(User user);
	public Object findUserByUsername(String loginName);
	
}
