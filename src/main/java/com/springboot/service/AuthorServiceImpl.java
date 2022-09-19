package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.constant.WebappConstant;
import com.springboot.model.AuthorDetails;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<AuthorDetails> listAuthors() {
		@SuppressWarnings("unchecked")
		List<AuthorDetails> authorDetails = (List<AuthorDetails>) this.restTemplate
				.getForObject(WebappConstant.LOCALHOST9001AUTHOR, List.class);
		return authorDetails;
	}

}
