package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.UserGroupMapping;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户与用户组映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserGroupMappingService extends BaseService<UserGroupMapping> {
    void bindMapping(Long groupId, List<Long> userIds);

    void removeByGroupId(Serializable groupId);
}
