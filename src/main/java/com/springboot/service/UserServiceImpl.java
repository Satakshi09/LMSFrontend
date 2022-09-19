package com.springboot.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.constant.WebappConstant;
import com.springboot.model.UserDetails;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	UserDetails userDetails;

	private String encryptedString = null;
	@Override
	public void addUser(UserDetails userDetails) {
		this.restTemplate.postForObject(WebappConstant.LOCALHOST9001USER, userDetails, UserDetails.class);
	}

	@Override
	public List<UserDetails> listUsers() {
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetails = (List<UserDetails>) this.restTemplate
				.getForObject(WebappConstant.LOCALHOST9001USER, List.class);
		return userDetails;
	}
	@Override
	public UserDetails getUserByUsername(String username) {
		UserDetails userDetails = this.restTemplate.getForObject(WebappConstant.LOCALHOST9001USER + "/" + username,
				UserDetails.class);
		return userDetails;
	}

	@Override
	public UserDetails getUserByUsernameAndPassword(String username, String password) {
		RestTemplate restTemplate1 = new RestTemplate();
		UserDetails userDetails = restTemplate1
				.getForObject(WebappConstant.LOCALHOST9001USER + "/" + username + "/" + password, UserDetails.class);
		return userDetails;
	}

	public String encyptString(String plainText) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(plainText.getBytes());
			byte[] bytes = messageDigest.digest();
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			encryptedString = s.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptedString;

	}

}
