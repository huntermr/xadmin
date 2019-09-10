package com.xadmin.support.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.framework.base.BaseService;
import com.xadmin.framework.vo.PageRequest;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.vo.request.*;
import com.xadmin.support.core.vo.response.LoginResponseVo;
import com.xadmin.support.core.vo.response.UserAuthCache;
import com.xadmin.support.core.vo.response.UserResponseVo;

import java.util.List;

/**
 * <p>
 * 核心服务-用户表 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface IUserService extends BaseService<User> {
    User findByUserName(String userName);

    LoginResponseVo login(UserAccountVo accountVo);

    void logout(Long userId);

    void updateUserInfo(Long userId, UserInfoVo infoVo);

    void updateUserPwd(UserPwdVo userPwdVo);

    void addUser(AddUserVo userVo);

    UserResponseVo getUserInfo(Long userId);

    IPage<UserResponseVo> getUserList(UserFilterVo filterVo);

    List<User> getUserByGroup(Long groupId);

    void removeByUserId(Long userId);

    void bindRoleDeptPost(Long userId, String userRoles, String userDepts, String userPosts);

    void unbindRoleDeptPost(Long userId);

    void refreshUserAuthCache(Long userId);

    UserAuthCache getUserAuthCache(Long userId);
}
