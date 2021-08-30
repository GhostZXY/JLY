package com.jly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	/**
	 * @param u_username
	 * @param u_password
	 * @param u_nickname
	 * @param u_head
	 * @return
	 */
	@RequestMapping("/modify")
	public String modify (String u_username,String u_password,String u_nickname
			,@RequestParam("u_head") MultipartFile u_head){
		User user = new User();
		user.setU_username(u_username);
		user.setU_password(u_password);
		user.setU_nickname(u_nickname);
		
		System.out.println(u_username+","+u_password+","+u_nickname);
		if(u_head.getOriginalFilename().equals("")){
			userService.modifyUserInfo(user);
		}else{
			userService.modifyUserInfoWitHead(user, u_head);
		}
		return "redirect:/product/buyerhome.action";
	}
	
}
