package com.example.demo.config;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;



public class TokenAuthenticationService {
	  static final long EXPIRATIONTIME = 864_000_000; // 10 days
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";
	  static void addAuthentication(HttpServletResponse res,Authentication authresult) {
		  List<GrantedAuthority> gt=(List<GrantedAuthority>) authresult.getAuthorities();  
		 /* HashMap<String,Object> ht=new HashMap<String, Object>();
		  ht.put("roles",gt.get(0).getAuthority());*/
		  
		  String j=gt.get(0).getAuthority();
		  String JWT = Jwts.builder().claim("role",j)
		        .setSubject(authresult.getName())
		        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
		        .signWith(SignatureAlgorithm.HS512, SECRET)
		        .compact();
		    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		   
		    
		  }
	  static Authentication getAuthentication(HttpServletRequest request) {
		    String token = request.getHeader(HEADER_STRING);
		    if (token != null) {
		      // parse the token.
		      String user = Jwts.parser()
		          .setSigningKey(SECRET)
		          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
		          .getBody()
		          .getSubject();
		      return user != null ?
		          new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
		          null;
		    }
		    return null;
		  }
}
