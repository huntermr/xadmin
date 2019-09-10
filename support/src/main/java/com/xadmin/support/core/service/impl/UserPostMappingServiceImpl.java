package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.support.core.entity.UserDeptMapping;
import com.xadmin.support.core.entity.UserPostMapping;
import com.xadmin.support.core.mapper.UserPostMappingMapper;
import com.xadmin.support.core.service.IUserPostMappingService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户岗位映射 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class UserPostMappingServiceImpl extends BaseServiceImpl<UserPostMappingMapper, UserPostMapping> implements IUserPostMappingService {
    @Override
    public void removeByUserId(Long userId) {
        remove(new QueryWrapper<UserPostMapping>().eq("user_id", userId));
    }

    @Override
    public void bindMapping(Long userId, List<Long> postIds) {
        List<UserPostMapping> userDeptMappings = new ArrayList<>();
        for(Long postId : postIds){
            UserPostMapping mapping = new UserPostMapping();
            mapping.setUserId(userId);
            mapping.setPostId(postId);
            userDeptMappings.add(mapping);
        }
        saveBatch(userDeptMappings);
    }
}
