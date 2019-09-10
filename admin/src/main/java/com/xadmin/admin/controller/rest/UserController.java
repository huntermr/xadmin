/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.admin.controller.rest;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.admin.annotation.OpLog;
import com.xadmin.admin.constants.Urls;
import com.xadmin.admin.enums.OpType;
import com.xadmin.framework.constants.CoreErrorCode;
import com.xadmin.framework.exception.BaseException;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.constants.CoreConstants;
import com.xadmin.support.core.constants.UserErrorCode;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.exception.UserException;
import com.xadmin.support.core.service.IUserService;
import com.xadmin.support.core.vo.request.*;
import com.xadmin.support.core.vo.response.LoginResponseVo;
import com.xadmin.support.core.vo.response.UserResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Copyright (C), 2015-2019, xadmin
 * FileName: UserController
 * Author:   Ht
 * Date:     2019/3/9 11:31
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestController
@RequestMapping(Urls.USER_MODULE)
@Api(value = "用户相关", tags = "用户相关")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = Urls.USER_LOGIN, method = RequestMethod.PUT)
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @SentinelResource(value = "login", blockHandler = "sentinelLogin")
    public ResponseVo<LoginResponseVo> login(@Valid UserAccountVo accountVo) {
        // 校验参数
        if(StringUtils.isEmpty(accountVo.getUserName())){
            throw new UserException(UserErrorCode.USER_NAME_EMPTY_ERROR.getCode());
        }

        if(StringUtils.isEmpty(accountVo.getPassword())){
            throw new UserException(UserErrorCode.USER_PASSWORD_EMPTY_ERROR.getCode());
        }

        return new ResponseVo<>(userService.login(accountVo));
    }

    public ResponseVo<LoginResponseVo> sentinelLogin(UserAccountVo accountVo, BlockException blockException){
        return new ResponseVo<>(CoreErrorCode.SENTINEL_ERROR.getCode(), CoreErrorCode.SENTINEL_ERROR.getDesc());
    }

    @RequestMapping(value = Urls.USER_LOGOUT, method = RequestMethod.PUT)
    @ApiOperation(value = "用户注销", notes = "用户注销")
    @OpLog(description = "用户注销", opType = OpType.OTHER)
    public ResponseVo<LoginResponseVo> logout(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.logout(userId);

        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.USER_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @OpLog(description = "添加用户", opType = OpType.INSERT)
    public ResponseVo addUser(AddUserVo user) {
        // 校验参数
        if(StringUtils.isEmpty(user.getUserName())){
            throw new UserException(UserErrorCode.USER_NAME_EMPTY_ERROR.getCode());
        }

        if(StringUtils.isEmpty(user.getPassword())){
            throw new UserException(UserErrorCode.USER_PASSWORD_EMPTY_ERROR.getCode());
        }

        userService.addUser(user);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @OpLog(description = "编辑用户信息", opType = OpType.EDIT)
    public ResponseVo updateUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId, UserInfoVo infoVo) {
        userService.updateUserInfo(userId, infoVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_RESET_PWD, method = RequestMethod.PUT)
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @OpLog(description = "修改用户密码", opType = OpType.EDIT)
    public ResponseVo updateUserPwd(UserPwdVo userPwdVo) {
        userService.updateUserPwd(userPwdVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.USER_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<IPage<UserResponseVo>> getUser(UserFilterVo filterVo) {
        return new ResponseVo<>(userService.getUserList(filterVo));
    }

    @RequestMapping(value = Urls.USER_ALL, method = RequestMethod.GET)
    @ApiOperation(value = "分页获取用户列表", notes = "分页获取用户列表")
    public ResponseVo<List<User>> getAllUser(User user) {
        return new ResponseVo<>(userService.list(new QueryWrapper<>(user)));
    }

    @RequestMapping(value = Urls.USER_LIST_BY_GROUP, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户组关联用户", notes = "获取用户组关联用户")
    public ResponseVo<List<User>> getUserByGroup(@PathVariable("groupId") Long groupId) {
        return new ResponseVo<>(userService.getUserByGroup(groupId));
    }

    @RequestMapping(value = Urls.USER_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ResponseVo<UserResponseVo> getUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        return new ResponseVo<>(userService.getUserInfo(userId));
    }

    @RequestMapping(value = Urls.USER_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @OpLog(description = "删除用户", opType = OpType.DEL)
    public ResponseVo deleteUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.removeByUserId(userId);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.USER_CHANGE_LOCK, method = RequestMethod.PUT)
    @ApiOperation(value = "冻结/解冻用户", notes = "冻结/解冻用户")
    public ResponseVo deleteUser(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId,
                                 @ApiParam(value = "用户状态 'N' 正常 'L' 锁定", required = true) @RequestParam("userStatus") String userStatus) {
        if(CoreConstants.USER_LOCK.equals(userStatus) || CoreConstants.USER_NONE.equals(userStatus)){
            User user = new User();
            user.setUserId(userId);
            user.setUserStatus(userStatus);
            userService.updateById(user);
            return new ResponseVo<>();
        }else{
            throw new BaseException(CoreErrorCode.PARAM_ERROR.getCode());
        }
    }

    @RequestMapping(value = Urls.USER_AUTH_CACHE, method = RequestMethod.PUT)
    @ApiOperation(value = "刷新用户权限相关缓存(角色、权限)", notes = "刷新用户权限相关缓存(角色、权限)")
    public ResponseVo refreshUserAuthCache(@ApiParam(value = "用户ID", required = true) @PathVariable("userId") Long userId) {
        userService.refreshUserAuthCache(userId);
        return new ResponseVo();
    }

}
