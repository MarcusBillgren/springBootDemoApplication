package com.mb.projektarbete.cardealership.config;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Administrator implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	
	private String password;
	
	public Administrator() {
		
	}
	public Administrator(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Not used in this application
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}
	
	@Override
	public String getPassword() {
		
		return password;
	}
	
	@Override
	public String getUsername() {
		
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	@Override
	
	public boolean isEnabled() {
		
		return true;
	}

}
