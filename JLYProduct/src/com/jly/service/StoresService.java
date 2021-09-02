package com.jly.service;

import java.util.List;

import com.jly.bean.Product;
import com.jly.bean.Stores;

public interface StoresService {
	public Stores findAllStores(int id);
	public boolean addStore(Stores store);
	

}
