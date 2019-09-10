package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.UserGroupRoleMapping;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户组角色映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserGroupRoleMappingService extends BaseService<UserGroupRoleMapping> {
    void bindMapping(Long groupId, List<Long> roleIds);

    void removeByGroupId(Serializable groupId);
}
