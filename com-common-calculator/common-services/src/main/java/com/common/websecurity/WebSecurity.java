package com.common.websecurity;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter
{
	@Autowired
	private RequestFilter request;
	
	@Autowired
	private UserDetailService user;
	
	
	@Bean
	public AuthenticationManager authenticationManagerBean(AuthenticationManagerBuilder auth) throws Exception
	{
		return super.authenticationManagerBean();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(user).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return  new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity https) throws Exception
	{
		https
		.authorizeRequests()
		.antMatchers("/api").permitAll()
		.anyRequest().authenticated()
		.and().cors().disable()
		.csrf().disable();
		https.addFilterAfter((Filter)request, BasicAuthenticationFilter.class);
	}
	
}
