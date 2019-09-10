package com.xadmin.support.core.mapper;

import com.xadmin.support.core.entity.UserGroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户组 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    List<Long> getUserGroupIds(Long userId);
}
