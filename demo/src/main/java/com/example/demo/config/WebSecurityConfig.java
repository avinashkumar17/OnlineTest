package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl user;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub

		http.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login")
				.permitAll()
				.antMatchers(HttpMethod.POST,"/signup")
				.permitAll()
				.antMatchers(HttpMethod.POST,"/addCategory")
				.permitAll()
				.antMatchers(HttpMethod.POST,"/removeCategory")
				.permitAll()
				.antMatchers(HttpMethod.POST,"/editCategory")
				.permitAll()
				.antMatchers(HttpMethod.GET, "/getCategory")
<<<<<<< HEAD
				.hasAnyAuthority("student","admin")
=======
				.permitAll()
				.antMatchers(HttpMethod.GET, "/test")
				.permitAll()
>>>>>>> 64553443cf3b51a13fb27bda271cda9a3b390651
				.antMatchers(HttpMethod.GET, "/getQuestions/*")
				.hasAnyAuthority("student","admin")
				.antMatchers(HttpMethod.GET, "/getLevels/*")
				.hasAnyAuthority("student","admin")
				.anyRequest()
				.authenticated()
				.and()
				.addFilterBefore(
						new JWTLoginFilter("/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in
				// header
				.addFilterBefore(new JWTAuthenticationFilter(),
						UsernamePasswordAuthenticationFilter.class)
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// TODO Auto-generated method stub

		// auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
		auth.userDetailsService(user);

	}

}
