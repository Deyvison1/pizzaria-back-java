package com.pizzaria.api.config.jwt.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pizzaria.api.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl {

	@Value("${security.jwt.expiracao}")
	private String expiracao;
	@Value("{security.jwt.chave-seguranca}")
	private String securityKey;

	public String generateToken(User user) {
		long expString = Long.valueOf(expiracao);
		LocalDateTime dateHoursExpiration = LocalDateTime.now().plusMinutes(expString);
		Instant instat = dateHoursExpiration.atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instat);

		HashMap<String, Object> claims = new HashMap<>();

		return Jwts.builder().setSubject(user.getEmail()).setExpiration(date)
				.signWith(SignatureAlgorithm.HS512, securityKey).compact();
	}

	private Claims getClaims(String token) throws ExpiredJwtException {
		return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody();
	}

	public boolean tokenValid(String token) {
		try {
			Claims claims = getClaims(token);
			Date dateExpation = claims.getExpiration();
			LocalDateTime date = dateExpation.toInstant().atZone((ZoneId.systemDefault())).toLocalDateTime();
			return !LocalDateTime.now().isAfter(date);
		} catch (Exception e) {
			return false;
		}
	}

	public String getUserEmail(String token) throws ExpiredJwtException {
		return (String) getClaims(token).getSubject();
	}
}
