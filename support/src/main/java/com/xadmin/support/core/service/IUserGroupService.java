package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.Role;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.entity.UserGroup;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户组 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserGroupService extends BaseService<UserGroup> {
    void bindUsers(Long groupId, List<Long> userIds);

    void bindRoles(Long groupId, List<Long> roleIds);

    List<Long> getUserGroupIds(Long userId);

}
