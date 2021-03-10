package com.demo.springBoot.configuration;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.demo.springBoot.jwt.JwtTokenVerfier;
import com.demo.springBoot.jwt.JwtUsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	private JwtConfig jwtConfig;
	private SecretKey secretKey;
	
	
	
	public SecurityConfiguration(JwtConfig jwtConfig, SecretKey secretKey) {
		super();
		this.jwtConfig = jwtConfig;
		this.secretKey = secretKey;
		
	}
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new UsernamePasswordAuthenticationFilter(authenticationManager(),jwtConfig,secretKey))
			.addFilterAfter(new JwtTokenVerfier(secretKey,jwtConfig), JwtUsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/products").hasAnyRole("USER","ADMIN")
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
			.and()
				//.httpBasic();
				.formLogin()
				
				  .loginPage("/signIn") .permitAll()
				 
			.and()
				.logout().permitAll()
				.logoutUrl("/logout")
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/");
			
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
			
		 	/*.inMemoryAuthentication()
		 	.withUser("swikriti")
		 	.password(passwordEncoder().encode("swik"))
		 	.roles("USER")
		 	.and()
		 	.withUser("shikha")
		 	.password(passwordEncoder().encode("shikhu"))
		 	.roles("ADMIN");*/
			
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
