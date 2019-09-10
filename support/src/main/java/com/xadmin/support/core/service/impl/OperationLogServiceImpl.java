package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.framework.base.BaseServiceImpl;
import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.mapper.OperationLogMapper;
import com.xadmin.support.core.service.IOperationLogService;
import com.xadmin.support.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class OperationLogServiceImpl extends BaseServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {
    @Autowired
    private IUserService userService;

    @Async
    @Override
    public void asyncSave(OperationLog log) {
        Long userId = log.getUserId();
        if(userId != null){
            User userInfo = userService.getById(userId);
            log.setUsername(userInfo.getUserName());
        }
        save(log);
    }

    @Override
    public List<OperationLog> list(Wrapper<OperationLog> queryWrapper) {
        return super.list(((QueryWrapper<OperationLog>)queryWrapper).orderByDesc("ct"));
    }

    @Override
    public IPage<OperationLog> page(IPage<OperationLog> page, Wrapper<OperationLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<OperationLog>)queryWrapper).orderByDesc("ct"));
    }
}
