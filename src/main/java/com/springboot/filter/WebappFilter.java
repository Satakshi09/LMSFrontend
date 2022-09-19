package com.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebappFilter implements Filter {

	Logger log = LoggerFactory.getLogger(WebappFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;

		if (servletRequest.getRequestURI().startsWith("/bookList")
				|| servletRequest.getRequestURI().startsWith("/addform")
				|| servletRequest.getRequestURI().startsWith("/editForm")) {
			HttpSession session = servletRequest.getSession();
			if (session.getAttribute("user") == null) {
				servletRequest = new HttpServletRequestWrapper((HttpServletRequest) request) {
					public String getRequestURI() {
						return "/login";
					}
				};
			}
		}
		chain.doFilter(servletRequest, response);
	}
}
