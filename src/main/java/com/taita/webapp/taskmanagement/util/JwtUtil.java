package com.taita.webapp.taskmanagement.util;

import com.taita.webapp.taskmanagement.entity.User;
import com.taita.webapp.taskmanagement.exception.AccessDeniedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static String SECRET = "kzxm0Ng3+u943X8ntHQu4+vPXJbCEek9JSuQRnIxn6fGigSFsWVrXsF5bvVXDD70zlnhqBlH5WeWef+7tJ75qNCN3dMtOnCXP/+ThhT0Orw=";
    private static long expiryDuration = 60 * 30 ;
    public String generateAccessToken(User user){
        long currentTimeMillis = System.currentTimeMillis();

        long expireTime = currentTimeMillis + expiryDuration * 1000;
        Date issuedAt = new Date(currentTimeMillis);
        Date expiredAt = new Date(expireTime);

        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiredAt);

        claims.put("firstName",user.getFirstName());
        claims.put("lastName",user.getLastName());
        claims.put("email",user.getEmail());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512,SECRET).compact();
    }

    public Claims verifyAccessToken(String authorization) throws Exception{

        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(authorization).getBody();
            System.out.println(claims.get("email"));
            return claims;
        }catch (Exception e){
            throw new AccessDeniedException("Access Denied! Please login again");
        }
    }
}
