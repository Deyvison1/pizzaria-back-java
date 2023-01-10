package com.pizzaria.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pizzaria.api.config.jwt.impl.JwtAuthFilter;
import com.pizzaria.api.config.jwt.impl.JwtServiceImpl;
import com.pizzaria.api.models.enums.ROLES;
import com.pizzaria.api.services.impl.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl usuarioService;
	@Autowired
	private JwtServiceImpl jwtService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, usuarioService);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeRequests()
             .antMatchers("/api/order/**")
                 .hasAnyRole("USER", "ADMIN")
             .antMatchers("/api/item/**")
                 .hasAnyRole("USER", "ADMIN")
             .antMatchers("/api/product/**")
                 .hasRole("ADMIN")
             .antMatchers(HttpMethod.POST, "/api/user/**")
                 .permitAll()
             .anyRequest().authenticated()
         .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
             .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
