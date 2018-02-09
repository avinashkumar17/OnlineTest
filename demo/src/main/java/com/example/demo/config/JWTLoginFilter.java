package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	protected JWTLoginFilter(String defaultFilterProcessesUrl,
			AuthenticationManager authManager) {
		super(defaultFilterProcessesUrl);
		setAuthenticationManager(authManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse arg1) throws AuthenticationException,
			IOException, ServletException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(userName, password,
						java.util.Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("the ***************** response "+response.toString());
		TokenAuthenticationService.addAuthentication(response, authResult);

	}

}
