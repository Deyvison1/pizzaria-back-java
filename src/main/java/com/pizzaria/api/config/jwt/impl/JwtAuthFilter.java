package com.pizzaria.api.config.jwt.impl;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pizzaria.api.services.impl.UserDetailsServiceImpl;

public class JwtAuthFilter extends OncePerRequestFilter {

	private JwtServiceImpl jwtService;
	private UserDetailsServiceImpl userDetailsServiceImpl;

	public JwtAuthFilter(JwtServiceImpl jwtService, UserDetailsServiceImpl userDetailsServiceImpl) {
		this.jwtService = jwtService;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorization = request.getHeader("Authorization");

		if (authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];
			boolean isValid = jwtService.tokenValid(token);

			if (isValid) {
				String userEmail = jwtService.getUserEmail(token);
				UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userEmail);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		filterChain.doFilter(request, response);
	}

}
