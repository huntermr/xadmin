package com.xadmin.support.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.vo.request.UserFilterVo;
import com.xadmin.support.core.vo.response.UserResponseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 核心服务-用户表 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-03-07
 */
public interface UserMapper extends BaseMapper<User> {
    User findByUserName(String userName);

    IPage<UserResponseVo> getUserList(Page page, @Param("param") UserFilterVo filterVo);

    List<User> getUserByGroupId(Long groupId);
}
