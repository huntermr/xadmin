package com.xadmin.support.core.service;

import com.xadmin.support.core.entity.UserRoleMapping;
import com.xadmin.framework.base.BaseService;

import java.util.List;

/**
 * <p>
 * 用户角色映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserRoleMappingService extends BaseService<UserRoleMapping> {
    void removeByRoleId(Long roleId);

    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> roleIds);
}
