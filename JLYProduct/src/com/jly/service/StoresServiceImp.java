package com.jly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jly.bean.Product;
import com.jly.bean.Stores;
import com.jly.dao.StoresDao;
import com.jly.dao.UserDao;
@Service(value="StoresService")
public class StoresServiceImp implements StoresService {
	@Resource
	StoresDao storesDao;
	@Resource
	UserDao userDao;
	public Stores findAllStores(int id) {
		return storesDao.querryAllStores(id);
	}
	@Override
	public boolean addStore(Stores store) {
		// TODO Auto-generated method stub
		
		return storesDao.addStore(store)!=0;
	}
	
	
	

}
