package com.maxaramos.hotelbookingjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

import com.maxaramos.hotelbookingjpa.service.UserService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Value("${app.security.realm-name}")
	private String realmName;

	@Value("${app.security.digest.key}")
	private String digestKey;

	@Bean
	public PasswordEncoder passwordEncoder() {
		// For non digest auth.
		return new BCryptPasswordEncoder();

		// For digest auth only.
//		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public BasicAuthenticationEntryPoint basicAuthenticationEntryPoint() {
		BasicAuthenticationEntryPoint entryPoint = new BasicAuthenticationEntryPoint();
		entryPoint.setRealmName(realmName);
		return entryPoint;
	}

	@Bean
	public DigestAuthenticationEntryPoint digestAuthenticationEntryPoint() {
		DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
		entryPoint.setRealmName(realmName);
		entryPoint.setKey(digestKey);
		return entryPoint;
	}

	@Bean
	public DigestAuthenticationFilter digestAuthenticationFilter(UserService userService) {
		DigestAuthenticationFilter filter = new DigestAuthenticationFilter();
		filter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint());
		filter.setUserDetailsService(userService);
		return filter;
	}

	@Configuration
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private BasicAuthenticationEntryPoint basicAuthenticationEntryPoint;

		@Autowired
		private DigestAuthenticationEntryPoint digestAuthenticationEntryPoint;

		@Autowired
		private DigestAuthenticationFilter digestAuthenticationFilter;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/api/**")
				.authorizeRequests()
//					.antMatchers(HttpMethod.GET, "/api/hotels/{hotelId:\\d+}/rooms/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST")
//					.antMatchers("/api/hotels/{hotelId:\\d+}/rooms/**").hasRole("MANAGER")
//					.antMatchers(HttpMethod.GET, "/api/hotels/{id:\\d+}").hasAnyRole("ADMIN", "MANAGER")
//					.antMatchers("/api/hotels/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					.and()
				.httpBasic()
					.authenticationEntryPoint(basicAuthenticationEntryPoint)
					.and()
//				.addFilterAt(digestAuthenticationFilter, BasicAuthenticationFilter.class)
//				.exceptionHandling()
//					.authenticationEntryPoint(digestAuthenticationEntryPoint)
//					.and()
				.csrf().disable();
		}

	}

	@Configuration
	public static class PageSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.antMatchers("/css/**", "/js/**", "/img/**", "/webjars/**").permitAll()
//					.antMatchers(HttpMethod.GET, "/hotels/{hotelId:\\d+}/rooms/**").hasAnyRole("ADMIN", "MANAGER", "RECEPTIONIST")
//					.antMatchers("/hotels/{hotelId:\\d+}/rooms/**").hasRole("MANAGER")
//					.antMatchers(HttpMethod.GET, "/hotels/{id:\\d+}").hasAnyRole("ADMIN", "MANAGER")
//					.antMatchers("/hotels/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.logoutSuccessUrl("/")
					.and()
				.headers()
					.frameOptions().sameOrigin()
					.and()
				.csrf().disable();
		}

	}

}




