package com.demo.springBoot.configuration;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

import lombok.Data;
@Data
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

	private String secretKey;
	private String tokenPrefix;
	private Integer tokenExpirationAfterDays;
	
	
	public String getAuthorizationHeader() {
		return HttpHeaders.AUTHORIZATION;
	}
}
