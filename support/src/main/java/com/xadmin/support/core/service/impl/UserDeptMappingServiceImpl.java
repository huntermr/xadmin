package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.UserDeptMapping;
import com.xadmin.support.core.entity.UserRoleMapping;
import com.xadmin.support.core.mapper.UserDeptMappingMapper;
import com.xadmin.support.core.service.IUserDeptMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户部门映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserDeptMappingServiceImpl extends BaseServiceImpl<UserDeptMappingMapper, UserDeptMapping> implements IUserDeptMappingService {

    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserDeptMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> deptIds) {
        List<UserDeptMapping> userDeptMappings = new ArrayList<>();
        for(Long deptId : deptIds){
            UserDeptMapping mapping = new UserDeptMapping();
            mapping.setUserId(userId);
            mapping.setDeptId(deptId);
            userDeptMappings.add(mapping);
        }
        saveBatch(userDeptMappings);
    }
}
