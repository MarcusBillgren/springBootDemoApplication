package com.mb.projektarbete.cardealership.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity httpsecurity)throws Exception{
		
		 httpsecurity.authorizeRequests().antMatchers("/", "/browse").permitAll().anyRequest().authenticated()
		 .and()
		 .formLogin().loginPage("/login").permitAll()
		 .and()
		 .logout().permitAll();
		 
	}

}
