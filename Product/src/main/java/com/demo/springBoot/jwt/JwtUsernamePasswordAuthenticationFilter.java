package com.demo.springBoot.jwt;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.springBoot.bean.User;
import com.demo.springBoot.configuration.JwtConfig;
import com.demo.springBoot.configuration.JwtSecretKey;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;

public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private JwtConfig jwtConfig;
	private JwtSecretKey jwtSecretKey;
	
	
	@Autowired
	public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig,
			JwtSecretKey jwtSecretKey) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtConfig = jwtConfig;
		this.jwtSecretKey = jwtSecretKey;
	}

	public JwtUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Authentication authenticate = null;
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

			Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),
					user.getPassword());
			authenticate = authenticationManager.authenticate(authentication);

			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authenticate;
		
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		int year=0,month=0,date=0;
		
		String token=Jwts.builder()
			.setSubject(authResult.getName())
			.claim("authorities", authResult.getAuthorities())
			.setIssuedAt(new Date(year,month,date))
			.setExpiration(Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
			.signWith(jwtSecretKey)
			.compact();
	
		response.addHeader(jwtConfig.getAuthorizationHeader(), jwtConfig.getTokenPrefix()+token);
	}
}
