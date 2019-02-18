package io.ryanluoxu.customerManager.base.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.ryanluoxu.customerManager.base.constant.RoleConstant;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles(RoleConstant.ADMIN);
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
			.withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles(RoleConstant.USER);
	
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
//				.loginProcessingUrl("/login")
				.successHandler(new CustomAutherticationSuccessHandler());

	}


	
}
