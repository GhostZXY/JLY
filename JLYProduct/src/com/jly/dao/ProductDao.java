package com.jly.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jly.bean.Product;

public interface ProductDao {
	public List<Product> querryAllProduct();
	public Product querryProductById(@Param("p_id")int p_id);
	public List<Product> querryProductBySid(@Param("s_id")int s_id);


}
