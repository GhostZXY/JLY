package com.jly.service;

import java.util.List;

import com.jly.bean.Product;;

public interface ProductService {
	public List<Product> findAllProduct();
	public Product findProductById(int p_id);
	public List<Product> querryProductList(int id);
	
}
