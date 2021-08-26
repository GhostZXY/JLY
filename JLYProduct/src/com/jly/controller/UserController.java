package com.jly.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jly.bean.User;
import com.jly.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "UserService")
	UserService userService;

	
	
	@RequestMapping("/home")
	public String home(Model model){
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList",userList);
		return "home";
	}
	@RequestMapping("/info")
	public String home(Model model,int id){
		User user = userService.findUserById(id);
		model.addAttribute("user",user);
		return "userinfo";
	}
}
