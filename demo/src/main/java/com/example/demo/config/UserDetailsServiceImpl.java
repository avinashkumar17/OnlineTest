package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminLogin;
import com.example.demo.service.Inter;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired Inter dao;
  	
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		List<AdminLogin> kk=dao.getAdminDetails(arg0);		
	if(kk.size() == 0)
	{
		throw  new UsernameNotFoundException(arg0);
	}	
		// TODO Auto-generated method stub
		return new User(kk.get(0).getUsername(), kk.get(0).getPassword(),getAuthRole(kk.get(0).getRole()));
	}
	
	
	private static List<GrantedAuthority> getAuthRole(String role){
		 List<GrantedAuthority> al=new ArrayList<GrantedAuthority>();
		 al.add(new SimpleGrantedAuthority(role));
		 return al;
	 }

}
