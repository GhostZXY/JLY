package com.jly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jly.bean.Stores;

public interface StoresDao {

	public Stores querryAllStores(@Param("u_id") int id);
	
	public int addStore(Stores stores);
}
