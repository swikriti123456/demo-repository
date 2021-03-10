package com.demo.springBoot.configuration;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.springBoot.bean.User;

public class CustomUserDetails extends User implements UserDetails
{

	public CustomUserDetails(final User user) {
		super(user);
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
	
		return super.getEmail();
	}
	@Override
	public boolean isEnabled() {
		
		return super.isEnabled();
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return super.isEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return super.isEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return super.isEnabled();
	}

}
