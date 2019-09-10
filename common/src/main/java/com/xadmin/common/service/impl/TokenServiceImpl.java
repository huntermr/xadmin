package com.xadmin.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.xadmin.common.service.RedisService;
import com.xadmin.common.service.TokenService;
import com.xadmin.common.util.JWTUtil;
import com.xadmin.common.vo.AuthTokenVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: Ht
 * @Date: 2018/2/23 16:31
 * @Description:
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private RedisService redisService;
    @Value("${app.jwt.token.rediskey}")
    private String tokenRedisKey;
    @Value("${app.jwt.key}")
    private String key;
    @Value("${app.jwt.timeout}")
    private Long timeout;

    @Override
    public String createToken(String content){
        return createToken(content, timeout);
    }

    @Override
    public String createToken(String content, Long timeout){
        JWTUtil.init(key);
        return JWTUtil.createJWT(content, timeout);
    }

    @Override
    public AuthTokenVo parseToken(String token) {
        JWTUtil.init(key);
        Claims claims = null;
        claims = JWTUtil.parseJWT(token);
        if (claims != null) {
            String subject = claims.getSubject();
            return JSON.parseObject(subject, AuthTokenVo.class);
        }
        return null;
    }

    @Override
    public String refreshToken(String userId, String type) {
        AuthTokenVo tokenVo = new AuthTokenVo();
        tokenVo.setUserId(userId);
        tokenVo.setType(type);

        String token = createToken(JSON.toJSONString(tokenVo));
        redisService.set(getRedisKey(userId, type), token);
        return token;
    }

    @Override
    public void clearToken(String userId, String type) {
        redisService.remove(getRedisKey(userId, type));
    }

    @Override
    public String getCacheToken(String userId, String type) {
        return (String) redisService.get(getRedisKey(userId, type));
    }

    @Override
    public String getRedisKey(String userId, String type){
        String format = String.format(tokenRedisKey, type, userId);
        return format;
    }

    @Override
    public boolean verifyToken(String token) {
        JWTUtil.init(key);
        Claims claims = null;
        try {
            claims = JWTUtil.parseJWT(token);
        } catch (ExpiredJwtException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
