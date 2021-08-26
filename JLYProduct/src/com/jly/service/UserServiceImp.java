package com.jly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jly.bean.User;
import com.jly.dao.UserDao;
@Service(value="UserService")
public class UserServiceImp implements UserService {
	@Resource
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public List<User> findAllUser(){
		return userDao.querryAllUser();
	}

	@Override
	public User findUserById(int p_id) {
		// TODO Auto-generated method stub
		return userDao.querryUserById(p_id);
	}
}
