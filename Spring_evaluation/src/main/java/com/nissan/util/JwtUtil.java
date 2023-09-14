package com.nissan.util;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.nissan.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	// secret key for Token
	private static String secret = "THIS_IS_JAVA";
	private static String secret1 = "THIS_IS_JAVA1";

	// expiration time
	private static long expiryDuration = 60 * 60;
	// generate token: header.payload.signature

	public String generateJwt(User user) {
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		// set issuedTime and ExpiryTime in token
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);

		// claims
		Claims claim = Jwts.claims().setIssuer(user.getUserId().toString()).setIssuedAt(issuedAt)
				.setExpiration(expiryAt);

		// generate JWT token using claims
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String generateJwt1(User user1) {
		long milliTime = System.currentTimeMillis();
		long expiryTime = milliTime + expiryDuration * 1000;

		// set issuedTime and ExpiryTime in token
		Date issuedAt = new Date(milliTime);
		Date expiryAt = new Date(expiryTime);

		// claims
		Claims claim = Jwts.claims().setIssuer(user1.getUserId().toString()).setIssuedAt(issuedAt)
				.setExpiration(expiryAt);

		// generate JWT token using claims
		return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret1).compact();
	}

	// checking token is valid or not{

	public Claims verifyAdmin(String authorization) throws AccessDeniedException {
		try {
			Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
			return claim;

		} catch (Exception e) {
			throw new AccessDeniedException("Sorry access dennied");
		}
	}

	public Claims verifyCustomer(String authorization) throws AccessDeniedException {
		try {
			Claims claim = Jwts.parser().setSigningKey(secret1).parseClaimsJws(authorization).getBody();
			return claim;

		} catch (Exception e) {
			throw new AccessDeniedException("Sorry access dennied");
		}
	}
}
