package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.UserDeptMapping;
import com.xadmin.support.core.entity.UserGroupMapping;
import com.xadmin.support.core.mapper.UserGroupMappingMapper;
import com.xadmin.support.core.service.IUserGroupMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户与用户组映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserGroupMappingServiceImpl extends BaseServiceImpl<UserGroupMappingMapper, UserGroupMapping> implements IUserGroupMappingService {

    @Override
    public void bindMapping(Long groupId, List<Long> userIds) {
        List<UserGroupMapping> userGroupMappings = new ArrayList<>();
        for(Long userId : userIds){
            UserGroupMapping mapping = new UserGroupMapping();
            mapping.setGroupId(groupId);
            mapping.setUserId(userId);
            userGroupMappings.add(mapping);
        }
        saveBatch(userGroupMappings);
    }

    @Override
    public void removeByGroupId(Serializable groupId) {
        remove(new QueryWrapper<UserGroupMapping>().eq("group_id", groupId));
    }
}
