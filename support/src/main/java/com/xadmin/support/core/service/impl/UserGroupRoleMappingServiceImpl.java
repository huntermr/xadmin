package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.UserGroupMapping;
import com.xadmin.support.core.entity.UserGroupRoleMapping;
import com.xadmin.support.core.mapper.UserGroupRoleMappingMapper;
import com.xadmin.support.core.service.IUserGroupRoleMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户组角色映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserGroupRoleMappingServiceImpl extends BaseServiceImpl<UserGroupRoleMappingMapper, UserGroupRoleMapping> implements IUserGroupRoleMappingService {

    @Override
    public void bindMapping(Long groupId, List<Long> roleIds) {
        List<UserGroupRoleMapping> userGroupRoleMappings = new ArrayList<>();
        for(Long roleId : roleIds){
            UserGroupRoleMapping mapping = new UserGroupRoleMapping();
            mapping.setGroupId(groupId);
            mapping.setRoleId(roleId);
            userGroupRoleMappings.add(mapping);
        }
        saveBatch(userGroupRoleMappings);
    }

    @Override
    public void removeByGroupId(Serializable groupId) {
        remove(new QueryWrapper<UserGroupRoleMapping>().eq("group_id", groupId));
    }
}
