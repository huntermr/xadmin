package com.xadmin.support.core.service.impl;

import com.xadmin.framework.base.BaseServiceImpl;
import com.xadmin.support.core.entity.Post;
import com.xadmin.support.core.mapper.PostMapper;
import com.xadmin.support.core.service.IPostService;
import com.xadmin.support.core.service.IUserPostMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class PostServiceImpl extends BaseServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    private IUserPostMappingService userPostMappingService;

    @Override
    public List<Post> getUserPosts(Long userId) {
        List<Post> userDepts = baseMapper.getUserPosts(userId);
        return userDepts;
    }

    @Override
    public void bindUserPost(Long userId, List<Long> postIds) {
        // 删除用户部门映射表中该用户的所有关系
        userPostMappingService.removeByUserId(userId);

        // 重新构建新的绑定关系
        userPostMappingService.bindMapping(userId, postIds);
    }
}
