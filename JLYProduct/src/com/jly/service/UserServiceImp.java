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

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.queryUserByUsername(user.getU_username())==null){
			return userDao.addUser(user)!=0;
		}
		return false;
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		User u = userDao.queryUserByUsername(user.getU_username());
		if(u!=null && u.getU_password().equals(user.getU_password())){
				return true;
		}
		return false;
	}

	@Override
	public Object findUserByUsername(String loginName) {
		// TODO Auto-generated method stub
		return userDao.queryUserByUsername(loginName);
	}
}
