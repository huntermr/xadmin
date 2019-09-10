package com.xadmin.support.core.service;

import com.xadmin.support.core.entity.UserDeptMapping;
import com.xadmin.framework.base.BaseService;

import java.util.List;

/**
 * <p>
 * 用户部门映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserDeptMappingService extends BaseService<UserDeptMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> deptIds);
}
