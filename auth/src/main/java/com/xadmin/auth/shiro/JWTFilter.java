package com.xadmin.auth.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xadmin.auth.config.AuthAnonConfig;
import com.xadmin.auth.constants.AuthErrorCode;
import com.xadmin.auth.constants.WebConstants;
import com.xadmin.auth.exception.AuthException;
import com.xadmin.common.service.TokenService;
import com.xadmin.common.util.SpringUtils;
import com.xadmin.common.vo.AuthTokenVo;
import com.xadmin.framework.vo.ResponseVo;
import org.apache.http.HttpStatus;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.apache.catalina.manager.Constants.CHARSET;

public class JWTFilter extends BasicHttpAuthenticationFilter {

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    private Logger log = LoggerFactory.getLogger(JWTFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {
        AuthAnonConfig authAnonConfig = SpringUtils.getBean(AuthAnonConfig.class);
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        if (isLoginAttempt(request, response)) {
            return executeLogin(request, response);
        }

        // 读取白名单路由列表
        List<String> anonurl = authAnonConfig.getAnonurl();

        for (String url : anonurl) {
            if (pathMatcher.match(url, httpServletRequest.getRequestURI())){
                return true;
            }
        }

        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(WebConstants.HEADER_TOKEN);
        return !StringUtils.isEmpty(token);
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        TokenService tokenService = SpringUtils.getBean(TokenService.class);

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(WebConstants.HEADER_TOKEN);

        try {
            AuthTokenVo tokenVo = tokenService.parseToken(token);
            // 因为登录时未将令牌放入,所以此时需要将令牌放入以便后续Realm进行用户认证
            tokenVo.setToken(token);
            getSubject(request, response).login(tokenVo);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 构建未授权的请求返回,filter层的异常不受exceptionAdvice控制,这里返回401,把返回的json丢到response中
     */
    @Override
    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        String contentType = "application/json;charset=" + CHARSET;
        httpResponse.setContentType(contentType);
        try {
            PrintWriter printWriter = httpResponse.getWriter();
            printWriter.append(JSON.toJSONString(new ResponseVo(AuthErrorCode.UNAUTH_ERROR.getCode(), AuthErrorCode.UNAUTH_ERROR.getDesc()), SerializerFeature.WriteMapNullValue));
        } catch (IOException e) {
            log.error("sendChallenge error,can not resolve httpServletResponse");
        }

        return false;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 跨域时,option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.SC_OK);
            return false;
        }

        return super.preHandle(request, response);
    }
}