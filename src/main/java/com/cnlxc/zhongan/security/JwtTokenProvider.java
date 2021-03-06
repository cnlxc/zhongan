package com.cnlxc.zhongan.security;

import com.cnlxc.zhongan.security.UserPrincipal;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Created by 82138 on 2019/12/4.
 */
@Slf4j
@Component
public class JwtTokenProvider {
    @Value("${app.JWTZhonganSuperSecretKey}")
    private String jwtSecret;
    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    // 根据用户ID生成TOKEN
    public String generateToken(Authentication authentication){
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        return Jwts.builder()
                .setSubject(String.valueOf(userPrincipal.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();

    }
    // 根据TOKEN推出用户ID
    public long getIdFromToken(String token){
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            log.error("Invalid JWT Signature.");
        }catch (ExpiredJwtException ex){
            log.error("Expired JWT token.");
        }catch (UnsupportedJwtException ex){
            log.error("Unsupported JWT Token");
        }
        return false;

    }
}
