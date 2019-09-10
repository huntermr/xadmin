package com.xadmin.auth.shiro;

import com.xadmin.auth.constants.AuthErrorCode;
import com.xadmin.auth.exception.AuthException;
import com.xadmin.common.service.TokenService;
import com.xadmin.common.vo.AuthTokenVo;
import com.xadmin.support.core.constants.CoreConstants;
import com.xadmin.support.core.entity.Resource;
import com.xadmin.support.core.entity.Role;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.service.IResourceService;
import com.xadmin.support.core.service.IRoleService;
import com.xadmin.support.core.service.IUserService;
import com.xadmin.support.core.vo.response.ResourceResponseVo;
import com.xadmin.support.core.vo.response.RoleInfoVo;
import com.xadmin.support.core.vo.response.UserAuthCache;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private TokenService tokenService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourceService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthTokenVo;
    }

    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principals 身份
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String) principals.getPrimaryPrincipal();

        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

//        // 获取用户角色集
//        List<Role> userRoles = roleService.getUserAllRoles(Long.parseLong(userId));
//        for(Role userRole : userRoles){
//            roleSet.add(userRole.getRoleKey());
//        }
//        simpleAuthorizationInfo.setRoles(roleSet);
//
//        // 获取用户权限集
//        List<Resource> userResources = resourceService.getResourcesByUserId(Long.parseLong(userId));
//        for(Resource userResource : userResources){
//            String resourcePerms = userResource.getResourcePerms();
//            if(!StringUtils.isEmpty(resourcePerms)){
//                permissionSet.add(resourcePerms);
//            }
//        }

        UserAuthCache userAuthCache = userService.getUserAuthCache(Long.parseLong(userId));
        if(userAuthCache != null){
            List<Role> userRoles = userAuthCache.getUserRoles();
            List<Resource> userResources = userAuthCache.getUserResources();

            if(!CollectionUtils.isEmpty(userRoles)){
                for(Role userRole : userRoles){
                    roleSet.add(userRole.getRoleKey());
                }
            }
            simpleAuthorizationInfo.setRoles(roleSet);

            if(!CollectionUtils.isEmpty(userResources)) {
                for (Resource userResource : userResources) {
                    String resourcePerms = userResource.getResourcePerms();
                    if (!StringUtils.isEmpty(resourcePerms)) {
                        permissionSet.add(resourcePerms);
                    }
                }
            }
            simpleAuthorizationInfo.setStringPermissions(permissionSet);
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        // 这里的 token是从 JWTFilter 的 executeLogin 方法传递过来的,已经经过了解密
        String token = (String) authenticationToken.getCredentials();

        // 校验令牌有效性
        if (!StringUtils.isEmpty(token) && !tokenService.verifyToken(token)) {
            throw new AuthException(AuthErrorCode.TOKEN_ERROR.getCode());
        }

        AuthTokenVo tokenVo = tokenService.parseToken(token);
        String userId = tokenVo.getUserId();
        String type = tokenVo.getType();

        // 校验是否与缓存中的令牌一致
        String cacheToken = tokenService.getCacheToken(userId, type);
        if(!token.equals(cacheToken)){
            throw new AuthException(AuthErrorCode.TOKEN_ERROR.getCode());
        }

        return new SimpleAuthenticationInfo(userId, token, getName());
    }
}