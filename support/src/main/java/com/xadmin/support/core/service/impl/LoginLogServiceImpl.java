package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.support.core.entity.LoginLog;
import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.support.core.mapper.LoginLogMapper;
import com.xadmin.support.core.service.ILoginLogService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 登录日志 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogMapper, LoginLog> implements ILoginLogService {
    @Override
    public List<LoginLog> list(Wrapper<LoginLog> queryWrapper) {
        return super.list(((QueryWrapper<LoginLog>)queryWrapper).orderByDesc("ct"));
    }

    @Override
    public IPage<LoginLog> page(IPage<LoginLog> page, Wrapper<LoginLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<LoginLog>)queryWrapper).orderByDesc("ct"));
    }
}
