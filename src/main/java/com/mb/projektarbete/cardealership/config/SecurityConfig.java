package com.mb.projektarbete.cardealership.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mb.projektarbete.cardealership.repositories.AdminRepo;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	protected void configure(HttpSecurity httpsecurity)throws Exception{
		
		 httpsecurity.authorizeRequests()
		 
		 .antMatchers("/", "/browse").permitAll().anyRequest().authenticated()
		 .and()
		 .formLogin().loginPage("/login").permitAll()
		 .and()
		 .logout().permitAll();
		 
		 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			auth
			.userDetailsService(new UserDetailsService() {
				@Override
				public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
					return adminRepo.findOne(username);
				}
			});
	}

}
