package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.UserRoleMapping;
import com.xadmin.support.core.mapper.UserRoleMappingMapper;
import com.xadmin.support.core.service.IUserRoleMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户角色映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserRoleMappingServiceImpl extends BaseServiceImpl<UserRoleMappingMapper, UserRoleMapping> implements IUserRoleMappingService {

    @Override
    public void removeByRoleId(Long roleId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("role_id", roleId));
    }

    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserRoleMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> roleIds) {
        List<UserRoleMapping> userRoleMappings = new ArrayList<>();
        for(Long roleId : roleIds){
            UserRoleMapping mapping = new UserRoleMapping();
            mapping.setUserId(userId);
            mapping.setRoleId(roleId);
            userRoleMappings.add(mapping);
        }
        saveBatch(userRoleMappings);
    }
}
