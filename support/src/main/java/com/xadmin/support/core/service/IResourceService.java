package com.xadmin.support.core.service;

import com.xadmin.support.core.entity.Resource;
import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.vo.response.ResourceResponseVo;

import java.util.List;

/**
 * <p>
 * 核心服务-资源表 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface IResourceService extends BaseService<Resource> {
    List<ResourceResponseVo> getTreeResources();

    List<ResourceResponseVo> getTreeResourcesByRoleId(Long roleId);

    List<Resource> getResourcesByRoleId(Long roleId);

    List<Resource> getResourcesByRoleIds(List<Long> roleIds);

    List<ResourceResponseVo> getUserTreeResources(Long userId);

    List<Resource> getResourcesByUserId(Long userId);

    ResourceResponseVo getResourceInfo(Long resourceId);

    List<Resource> getResourceByParentId(Long parentResourceId);

    void bindRoleResource(Long roleId, List<Long> resourceIds);

    void deleteById(Long resourceId);

}
