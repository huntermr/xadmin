package com.xadmin.support.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.Role;
import com.xadmin.support.core.vo.request.RoleFilterVo;
import com.xadmin.support.core.vo.response.RoleInfoVo;

import java.util.List;

/**
 * <p>
 * 核心服务-角色表 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface IRoleService extends BaseService<Role> {
    List<Role> getUserRoles(Long userId);

    List<Role> getUserAllRoles(Long userId);

    List<Long> getUserAllRoleIds(Long userId);

    List<Role> getGroupRoles(List<Long> groupIds);

    IPage<Role> getRoles(RoleFilterVo filterVo);

    void deleteById(Long roleId);

    void bindUserRole(Long userId, List<Long> roleIds);
}
