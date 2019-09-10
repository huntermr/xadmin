package com.xadmin.support.core.mapper;

import com.xadmin.support.core.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 部门信息 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> getUserDepts(Long userId);
}
