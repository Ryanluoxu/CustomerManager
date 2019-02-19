package io.ryanluoxu.customerManager.base.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.ryanluoxu.customerManager.base.constant.RoleConstant;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomAutherticationSuccessHandler autherticationSuccessHandler;

	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * method 1
		 */
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("ryan").password(new BCryptPasswordEncoder().encode("luoxu")).roles(RoleConstant.ADMIN);
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles(RoleConstant.USER);

		/*
		 * method 2 - for non-hash password
		 */
		auth.authenticationProvider(authenticationProvider);

		/*
		 * method 3
		 */
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("","","");
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/**
		 * restriction by folder structure
		 */
		http.authorizeRequests()
				.antMatchers("/pages/*").permitAll()
				.antMatchers("/pages/user/**").hasRole("USER")
				.antMatchers("/pages/admin/**").hasRole("ADMIN")
				.and()
			.formLogin()
				.failureUrl("/login?error")
				.loginProcessingUrl("/loginProcessing")
				.defaultSuccessUrl("/login?success")
				.successHandler(autherticationSuccessHandler);

	}



}
