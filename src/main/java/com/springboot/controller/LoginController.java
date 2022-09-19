package com.springboot.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.springboot.constant.WebappConstant;
import com.springboot.model.UserDetails;
import com.springboot.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return WebappConstant.LOGIN;
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/validate")
	public String validateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) throws NoSuchAlgorithmException {

		UserDetails userDetails = this.userService.getUserByUsernameAndPassword(username,
				userService.encyptString(password));
		session.setAttribute(WebappConstant.USER, userDetails);

		return WebappConstant.REDIRECTBOOKLIST;

	}

}
