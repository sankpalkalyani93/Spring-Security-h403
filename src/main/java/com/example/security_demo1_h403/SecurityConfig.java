package com.example.security_demo1_h403;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final CustomerDetailsService userDetailService;

	@Autowired
	public SecurityConfig(CustomerDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(
				authorizeRequests -> 
					authorizeRequests.requestMatchers("/register").permitAll()
					.requestMatchers("/public").permitAll().anyRequest().authenticated()
				).formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/secure", true).permitAll()
		);
		return httpSecurity.build();
	}
	
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}