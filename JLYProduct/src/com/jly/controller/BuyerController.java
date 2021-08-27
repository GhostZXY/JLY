package com.jly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jly.bean.Product;
import com.jly.bean.User;
import com.jly.service.ProductService;
import com.jly.service.UserService;

@Controller
@RequestMapping("/product")
public class BuyerController {
	@Resource(name = "ProductService")
	ProductService productService;
	@Resource(name = "UserService")
	UserService userService;
	
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
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
		return "productinfo";
	}
	@RequestMapping("/toRegister")
	public String toRegister(){
		return "register";
	}
	@RequestMapping("/register")
	public String register(User user){
		if(userService.addUser(user)){
			return "buyerHome";
		}
		return "register";
	}
	@RequestMapping("/toLogin")
	public String toLogin (){
		return "buyerLogin";
	}
	@ResponseBody
	@RequestMapping("/login")
	public String toLogin (User user,HttpServletResponse response){
		if(userService.login(user)){
			Cookie cookie = new Cookie("LOGINNAME", user.getU_username());
	 		response.addCookie(cookie);
			return "success";
		}
		return "failed";
	}
	@RequestMapping("/toModify")
	public String toModify (Model model,String loginName){
		model.addAttribute("userInfo", userService.findUserByUsername(loginName));
		return "buyerModify";
	}
	
}
