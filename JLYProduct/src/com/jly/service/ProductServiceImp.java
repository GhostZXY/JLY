package com.jly.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jly.bean.Product;
import com.jly.dao.ProductDao;
@Service(value="ProductService")
public class ProductServiceImp implements ProductService {
	
	@Resource
	ProductDao productDao;
	
	
	public ProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productDao.querryAllProduct();
	}


	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.querryProductById(id);
	}


	@Override
	public List<Product> querryProductList(int id) {
		// TODO Auto-generated method stub
		return productDao.querryProductBySid(id);
	}

}
