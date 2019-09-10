package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.Post;

import java.util.List;

/**
 * <p>
 * 岗位信息 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IPostService extends BaseService<Post> {
    List<Post> getUserPosts(Long userId);

    void bindUserPost(Long userId, List<Long> postIds);
}
