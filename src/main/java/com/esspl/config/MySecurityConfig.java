package com.esspl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.esspl.security.CustomUserDetailsService;
import com.esspl.security.JwtAuthenticationEntryPoint;
import com.esspl.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	public static final String[] PUBLIC_URLS= {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**",
			"/signin"
			
			
	};
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers(PUBLIC_URLS).permitAll()
		.antMatchers(HttpMethod.GET).permitAll()
		.anyRequest()
		.authenticated()
		.and().formLogin().loginPage("/signin")
		.loginProcessingUrl("/dologin").defaultSuccessUrl("/")
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and().exceptionHandling()
				.authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		DefaultSecurityFilterChain defaultSecurityFilterChain = http.build();
		return defaultSecurityFilterChain;
	}

	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customUserDetailsService);
		provider.setPasswordEncoder(this.passwordEncoder());
		return provider;

	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration)
			throws Exception {
		return configuration.getAuthenticationManager();
	}

}
