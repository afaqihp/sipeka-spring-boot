/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Faqih
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig 
extends WebSecurityConfigurerAdapter  {
	
	@Override
	protected void configure(HttpSecurity http) 
			throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/login", 
				"/resources/**", 
				"/assets/css/**",  
				"/assets/img/**").permitAll()
                 .antMatchers("/register", 
                                "/resources/**", 
                                "/assets/css/**", 
                                "/assets/image/**", 
                                "/assets/js/**").permitAll()
                .antMatchers("/users/addNew").permitAll()
                .antMatchers("/doctor/add").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll()
                        .and()
                        .exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}	
        
        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();		
		provider.setUserDetailsService(userDetailsService);
                
		provider.setPasswordEncoder(bCryptPasswordEncoder());
                
		return provider;
	}
}