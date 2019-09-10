package com.xadmin.support.core.service.impl;

import com.xadmin.framework.base.BaseServiceImpl;
import com.xadmin.support.core.constants.UserErrorCode;
import com.xadmin.support.core.entity.UserGroup;
import com.xadmin.support.core.exception.UserException;
import com.xadmin.support.core.mapper.UserGroupMapper;
import com.xadmin.support.core.service.IUserGroupMappingService;
import com.xadmin.support.core.service.IUserGroupRoleMappingService;
import com.xadmin.support.core.service.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户组 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroupMapper, UserGroup> implements IUserGroupService {
    @Autowired
    private IUserGroupMappingService userGroupMappingService;
    @Autowired
    private IUserGroupRoleMappingService userGroupRoleMappingService;

    @Override
    @Transactional
    public void bindUsers(Long groupId, List<Long> userIds) {
        UserGroup userGroup = getById(groupId);
        if(userGroup == null){
            throw new UserException(UserErrorCode.USER_GROUP_NOT_EXIST_ERROR.getCode());
        }

        userGroupMappingService.removeByGroupId(groupId);
        userGroupMappingService.bindMapping(groupId, userIds);
    }

    @Override
    @Transactional
    public void bindRoles(Long groupId, List<Long> roleIds) {
        userGroupRoleMappingService.removeByGroupId(groupId);
        userGroupRoleMappingService.bindMapping(groupId, roleIds);
    }

    @Override
    public List<Long> getUserGroupIds(Long userId) {
        return baseMapper.getUserGroupIds(userId);
    }

    @Override
    @Transactional
    public boolean removeById(Serializable id) {
        userGroupMappingService.removeByGroupId(id);
        userGroupRoleMappingService.removeByGroupId(id);

        return super.removeById(id);
    }
}
