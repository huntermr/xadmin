package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.Dept;
import com.xadmin.support.core.vo.response.DeptVo;

import java.util.List;

/**
 * <p>
 * 部门信息 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IDeptService extends BaseService<Dept> {
    List<DeptVo> getTreeDepts();

    List<Dept> getUserDepts(Long userId);

    List<Long> getDeptIdsByParentId(Long parentId);

    void bindUserDept(Long userId, List<Long> deptIds);
}
