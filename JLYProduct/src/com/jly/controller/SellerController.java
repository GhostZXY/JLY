package com.jly.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jly.bean.Product;
import com.jly.bean.Stores;
import com.jly.bean.User;
import com.jly.service.ProductService;
import com.jly.service.StoresService;
import com.jly.service.StoresServiceImp;
import com.jly.service.UserService;
@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Resource(name="StoresService")
	StoresService storesService ;
	@Resource(name="UserService")
	UserService userService;
	@Resource(name="ProductService")
	ProductService productService;
	
	
	
	
	@RequestMapping("/toLogin")
	public String toSellerLogin(){
		return "sellerLogin";
	}
	@ResponseBody
	@RequestMapping("login")
	public String sellerlogin(User user,HttpServletResponse response){
		if(userService.login(user)){
			User u = (User) userService.findUserByUsername(user.getU_username());
			response.addCookie(new Cookie("LOGINNAME", user.getU_username()));
			if(u.getU_hasstore().equals("1")){
				Stores stores = storesService.findAllStores(u.getU_id());
				response.addCookie(new Cookie("STORE", stores.getS_id()+""));
				response.addCookie(new Cookie("HASSTORE", "true"));
			}else{
				response.addCookie(new Cookie("STORE", ""));
				response.addCookie(new Cookie("HASSTORE", "false"));

			}
			return "success";
		}
		return "failed";	
	}
	@RequestMapping("/home")
	public String sellerrHome(Model model, HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String s_id ="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("STORE")){
				s_id = cookie.getValue();
			}
		}
	int id = Integer.parseInt(s_id);
	List<Product> productList = productService.querryProductList(id);
	model.addAttribute("productList", productList);
		return "sellerHome";
	}
	@RequestMapping("/toAddStore")
	public String toAddStore(Stores stores){
		
		return "addStore";
	}
	@RequestMapping("/addStore")
	public String AddStore(Stores stores,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String username ="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("LOGINNAME")){
			username = cookie.getValue();
			}
		}
		User user = userService.findUserByUsername(username);
		stores.setU_id(user.getU_id());
		if(storesService.addStore(stores)){
			userService.updateHasStore(user.getU_id());
		}
		
		return "sellerHome";
	}

	public StoresService getStoresService() {
		return storesService;
	}

	public void setStoresService(StoresService storesService) {
		this.storesService = storesService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
