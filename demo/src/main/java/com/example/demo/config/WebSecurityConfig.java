package com.example.demo.config;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sun.mail.handlers.handler_base;



@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired UserDetailsService user;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,"/login").permitAll().anyRequest().authenticated().and().addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                UsernamePasswordAuthenticationFilter.class)
        // And filter other requests to check the presence of JWT in header
        .addFilterBefore(new JWTAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// TODO Auto-generated method stub
		
		//auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
		auth.userDetailsService(user);
		 
	}

}