package com.jly.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jly.bean.User;

public interface UserService {
	public List<User> findAllUser();
	public User findUserById(int id);
	public boolean addUser(User user);
	public boolean login(User user);
	public User findUserByUsername(String loginName);
	public boolean modifyUserInfo(User user);
	public boolean modifyUserInfoWitHead(User user,MultipartFile head);
	public void updateHasStore(int id);
}
