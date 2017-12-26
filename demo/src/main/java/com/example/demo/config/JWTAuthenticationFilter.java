package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends  GenericFilterBean{
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 Authentication authentication = TokenAuthenticationService
			        .getAuthentication((HttpServletRequest)arg0);

			    SecurityContextHolder.getContext()
			        .setAuthentication(authentication);
			    arg2.doFilter(arg0,arg1);
	}

}
