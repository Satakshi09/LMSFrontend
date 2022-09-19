package com.springboot.service;

import java.util.List;

import com.springboot.model.UserDetails;

public interface UserService {

	public void addUser(UserDetails userDetails);

	public List<UserDetails> listUsers();

	public UserDetails getUserByUsername(String username);

	public UserDetails getUserByUsernameAndPassword(String username, String password);
	
	public String encyptString(String plainText);

}
