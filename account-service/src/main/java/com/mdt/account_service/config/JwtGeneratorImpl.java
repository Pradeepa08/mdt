package com.mdt.account_service.config;

import com.mdt.account_service.model.UserRequest;
import com.mdt.account_service.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtGeneratorImpl {
    private static final String SECRET_KEY = "secret";
    private static final long EXPIRATION_TIME = 3600000;
    public Map<String, String> generateToken(UserRequest userRequest) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME );
        String jwtToken="";
        jwtToken = Jwts.builder().setSubject(userRequest.getUserName()).setIssuedAt(now).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("accessToken", jwtToken);
        jwtTokenGen.put("tokenType", "Bearer");
        jwtTokenGen.put("expiresIn", expiryDate.toString());
        return jwtTokenGen;
    }
}
