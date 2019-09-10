/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.common.vo;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Copyright (C), 2015-2018, xadmin
 * FileName: AuthTokenVo
 * Author:   Ht
 * Date:     2018/6/14 19:00
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class AuthTokenVo implements AuthenticationToken {
    private String userId;
    private String type;
    private String token;

    public AuthTokenVo() {
    }

    public AuthTokenVo(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return getUserId();
    }

    @Override
    public Object getCredentials() {
        return getToken();
    }
}
