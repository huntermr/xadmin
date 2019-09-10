package com.xadmin.common.service;


import com.xadmin.common.vo.AuthTokenVo;

/**
 * @Author: Ht
 * @Date: 2018/2/23 16:31
 * @Description:
 */
public interface TokenService {

    String createToken(String content);

    String createToken(String content, Long timeout);

    AuthTokenVo parseToken(String token);

    String refreshToken(String userId, String type);

    void clearToken(String userId, String type);

    String getCacheToken(String userId, String type);

    String getRedisKey(String userId, String type);

    boolean verifyToken(String token);
}
