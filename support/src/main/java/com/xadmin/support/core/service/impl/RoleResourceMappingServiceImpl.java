package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.RoleResourceMapping;
import com.xadmin.support.core.mapper.RoleResourceMappingMapper;
import com.xadmin.support.core.service.IRoleResourceMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色资源映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class RoleResourceMappingServiceImpl extends BaseServiceImpl<RoleResourceMappingMapper, RoleResourceMapping> implements IRoleResourceMappingService {

    @Override
    public void removeByRoleId(Long roleId) {
        remove(new QueryWrapper<RoleResourceMapping>().eq("role_id", roleId));
    }

    @Override
    public void removeByResourceId(Long resourceId) {
        remove(new QueryWrapper<RoleResourceMapping>().eq("resource_id", resourceId));
    }

    @Override
    public void bindMapping(Long roleId, List<Long> resourceIds) {
        List<RoleResourceMapping> resourceMappings = new ArrayList<>();
        for(Long resourceId : resourceIds){
            RoleResourceMapping mapping = new RoleResourceMapping();
            mapping.setRoleId(roleId);
            mapping.setResourceId(resourceId);
            resourceMappings.add(mapping);
        }
        saveBatch(resourceMappings);
    }
}
