package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.RoleResourceMapping;

import java.util.List;

/**
 * <p>
 * 角色资源映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IRoleResourceMappingService extends BaseService<RoleResourceMapping> {
    void removeByRoleId(Long roleId);

    void removeByResourceId(Long resourceId);

    void bindMapping(Long roleId, List<Long> resourceIds);
}
