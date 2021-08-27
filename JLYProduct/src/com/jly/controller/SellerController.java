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
import com.jly.bean.Stores;
import com.jly.bean.User;
import com.jly.service.UserService;
@Controller
@RequestMapping("/seller")
public class SellerController {
	@Resource(name="UserService")
	UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/toLogin")
	public String toSellerLogin(){
		return "sellerLogin";
	}
	@ResponseBody
	@RequestMapping("login")
	public String sellerlogin(User user,HttpServletResponse response){
		if(userService.login(user)){
			User u = (User) userService.findUserByUsername(user.getU_username());
			if(u.getU_hasstore().equals("1")){
				response.addCookie(new Cookie("HASSTORE", "true"));
			}else{
				response.addCookie(new Cookie("HASSTORE", "false"));
			}
			return "success";
		}
		return "failed";	
	}
	@RequestMapping("/home")
	public String sellerrHome(){
		
		return "sellerHome";
	}
	@RequestMapping("/toAddStore")
	public String AddStore(){
		
		return "addStore";
	}
}
