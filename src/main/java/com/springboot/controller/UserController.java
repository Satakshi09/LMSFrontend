package com.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.constant.WebappConstant;
import com.springboot.model.UserDetails;
import com.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String showRegisterPage() {
		return WebappConstant.REGISTER;
	}

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserDetails userDetails) {
		userDetails.setPassword(userService.encyptString(userDetails.getPassword()));
		this.userService.addUser(userDetails);
		return WebappConstant.REDIRECTLOGIN;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute(WebappConstant.USER);
		return WebappConstant.REDIRECTLOGIN;
	}

}
