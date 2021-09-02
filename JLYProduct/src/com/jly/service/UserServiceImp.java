package com.jly.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jly.bean.Address;
import com.jly.bean.User;
import com.jly.dao.AddressDao;
import com.jly.dao.UserDao;
@Service(value="UserService")
public class UserServiceImp implements UserService {
	@Resource
	UserDao userDao;
	@Resource
	AddressDao addressDao;

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
	public User findUserByUsername(String loginName) {
		// TODO Auto-generated method stub
		return userDao.queryUserByUsername(loginName);
	}

	@Override
	public boolean modifyUserInfo(User user) {
		// TODO Auto-generated method stub
		
		return userDao.updataUser(user)!=0;
	}

	@Override
	public boolean modifyUserInfoWitHead(User user, MultipartFile head) {
		// TODO Auto-generated method stub
		if(modifyUserInfo(user)){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String sux = head.getOriginalFilename()
					.substring(head.getOriginalFilename().lastIndexOf("."));
			String new_name = sdf.format(date)+UUID.randomUUID()+sux;
			
			System.out.println(new_name);
			File file =new File("D:\\pic\\head\\"+new_name);
			try {
				head.transferTo(file);
				user.setU_head_old("/pic/head/"+new_name);
			
				return userDao.updateUserWithPic(user)!=0;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void updateHasStore(int id) {
		// TODO Auto-generated method stub
		Address address_old = addressDao.queryDefaultAddress(id);
		
		addressDao.uppDateAddress(address_old.getA_id(),"0");
		addressDao.uppDateAddress(id,"1");
	}
}
