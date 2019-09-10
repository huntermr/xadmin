package com.xadmin.support.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xadmin.support.core.entity.Post;

import java.util.List;

/**
 * <p>
 * 岗位信息 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface PostMapper extends BaseMapper<Post> {

    List<Post> getUserPosts(Long userId);
}
