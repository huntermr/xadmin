package com.xadmin.support.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xadmin.support.core.entity.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 核心服务-资源表 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface ResourceMapper extends BaseMapper<Resource> {
    List<Resource> getResources(@Param("roleIds") List<Long> roleIds);
}
