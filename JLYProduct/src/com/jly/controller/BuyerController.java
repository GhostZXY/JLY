package com.jly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jly.bean.Address;
import com.jly.bean.Product;
import com.jly.bean.User;
import com.jly.service.AddressService;
import com.jly.service.ProductService;
import com.jly.service.UserService;

@Controller
@RequestMapping("/product")
public class BuyerController {
	@Resource(name = "ProductService")
	ProductService productService;
	@Resource(name = "UserService")
	UserService userService;
	@Resource(name = "AddressService")
	AddressService addressService;
	
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
	public AddressService getAddressService() {
		return addressService;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
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
	
	@RequestMapping("/toAddressMenager")
	public String toAddressMenager(Model model,String username){
		User user = userService.findUserByUsername(username);
		List<Address> addressList =  addressService.findAllAddress(user.getU_id());
		model.addAttribute("addressList", addressList);
		return "addressMenager";
	}
	@RequestMapping("/setDefault")
	public String setDefault(int u_id,int a_id,HttpServletRequest request){
		addressService.updateDefaultAddress(u_id,a_id);
		Cookie[] cookies = request.getCookies();
		String username ="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("LOGINNAME")){
			username = cookie.getValue();
			}
		}
		return  "redirect:/product/toAddressMenager.action?username="+username;
	}
	@RequestMapping("toAddressAdd")
	public String AddressAdd(){
		return "addressAdd";
	}
	@RequestMapping("addressAdd")
	public String addressAdd(Address address,boolean a_default,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String username ="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("LOGINNAME")){
			username = cookie.getValue();
			}
		}
			User user = userService.findUserByUsername(username);
			address.setU_id(user.getU_id()+"");
			
			if(a_default){
				address.setA_isdefault("1");
				addressService.addDefaultAddress(address);
			}else{
				address.setA_isdefault("0");
				addressService.addAddress(address);
			}
			return "redirect:/product/toAddressMenager.action?username="+username;
	}
	@RequestMapping("addressDel")
	public String addressDel(int a_id,HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String username ="";
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("LOGINNAME")){
			username = cookie.getValue();
			}
		}
		addressService.deleteAddress(a_id);
		
			
		return "redirect:/product/toAddressMenager.action?username="+username;
	}
	@RequestMapping("/toCart")
	public String toCart(){
		return "cart";
	}
	@RequestMapping("/cart")
	public String cart(){
		return "cart";
	}
	
}
