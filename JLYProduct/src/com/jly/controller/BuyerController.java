package com.jly.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jly.bean.Product;
import com.jly.service.ProductService;

@Controller
@RequestMapping("/product")
public class BuyerController {
	@Resource(name = "ProductService")

	ProductService productService;
	
	@RequestMapping("/buyerhome")
	public String buyerHome(Model model){
		List<Product> productList = productService.findAllProduct();
		model.addAttribute("productList",productList);
		return "buyerHome";
	}
	@RequestMapping("/buyerinfo")
	public String buyerInfo(Model model,int p_id){
		Product product = productService.findProductById(p_id);
		model.addAttribute("product",product);
		return "buyerinfo";
	}
}
