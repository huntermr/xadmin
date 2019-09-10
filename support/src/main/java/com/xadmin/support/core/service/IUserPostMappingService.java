package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.UserPostMapping;

import java.util.List;

/**
 * <p>
 * 用户岗位映射 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IUserPostMappingService extends BaseService<UserPostMapping> {
    void removeByUserId(Long userId);

    void bindMapping(Long userId, List<Long> postIds);
}
