package com.demo.springBoot.jwt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.springBoot.configuration.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jdk.internal.joptsimple.internal.Strings;
import lombok.var;

public class JwtTokenVerfier extends OncePerRequestFilter {

	private SecretKey secretKey;
	private JwtConfig jwtConfig;
	
	@Autowired
	public JwtTokenVerfier(SecretKey secretKey, com.demo.springBoot.configuration.JwtConfig jwtConfig) {
		super();
		this.secretKey = secretKey;
		JwtConfig = jwtConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
		
		if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
			filterChain.doFilter(request, response);
			return;
		}
		String token=authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
		try {
			
			String secretKey="securesecuresecuresecure";
			Jws<Claims> claimsJws=Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token);
				Claims body=claimsJws.getBody();
				String username=body.getSubject();
			var authorities =(List<Map<String,String>>)body.get("authorities");
			
		Set<SimpleGrantedAuthority> simpleGrantedAuthority=	authorities.stream()
						.map(m -> new SimpleGrantedAuthority(m.get("authority")))
						.collect(Collectors.toSet());
			Authentication authentication=new UsernamePasswordAuthenticationToken(
					username,null,simpleGrantedAuthority
					);
					SecurityContextHolder.getContext().setAuthentication(authentication);
		}catch(JwtException e) {
			throw new IllegalStateException(String.format("Token %s cannot be trusted",token));
		}
		
		filterChain.doFilter(request, response);
	}

}
