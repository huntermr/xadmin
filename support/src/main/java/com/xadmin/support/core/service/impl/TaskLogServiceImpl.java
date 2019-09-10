package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.support.core.entity.TaskLog;
import com.xadmin.support.core.mapper.TaskLogMapper;
import com.xadmin.support.core.service.ITaskLogService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 定时任务日志 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class TaskLogServiceImpl extends BaseServiceImpl<TaskLogMapper, TaskLog> implements ITaskLogService {
    @Override
    public List<TaskLog> list(Wrapper<TaskLog> queryWrapper) {
        return super.list(((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
    }

    @Override
    public IPage<TaskLog> page(IPage<TaskLog> page, Wrapper<TaskLog> queryWrapper) {
        return super.page(page, ((QueryWrapper<TaskLog>)queryWrapper).orderByDesc("ct"));
    }
}
