package com.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	BCryptPasswordEncoder pe;

	/*--Ma hoa mat khau--*/
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserService userService;
	/*--quan ly nguoi du lieu nguoi su dung--*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}

	/*--phan quyen su dung va hinh thuc dang nhap--*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CDRP, CORS
		http.csrf().disable().cors().disable();

		// phan quyen su dung
		http.authorizeRequests()
//		.antMatchers("/home/admins").hasRole("ADMIN")
//		.antMatchers("/home/users").hasAnyRole("ADMIN","USER")
//		.antMatchers("/home/authenticated").authenticated()
				.anyRequest().permitAll();// anonymous

		// dieu khien loi truy cap khong dung vai tro
		http.exceptionHandling().accessDeniedPage("/auth/access/denied");// [/error]

		// giao dien dang nhap
		http.formLogin().loginPage("/auth/login/form").loginProcessingUrl("/auth/login")// [/login]
				.defaultSuccessUrl("/auth/login/success", false).failureUrl("/auth/login/error")
				.usernameParameter("username") // [username]
				.passwordParameter("password");// [password]
		http.rememberMe().rememberMeParameter("remember"); // [remember-me]

		// dang xuat
		http.logout().logoutUrl("/auth/logoff")// [/logout]
				.logoutSuccessUrl("/auth/logoff/success");

	}
}

