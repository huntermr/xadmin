package com.xadmin.admin.controller.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.admin.constants.Urls;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.vo.request.TaskLogFilterVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.TaskLog;
import com.xadmin.support.core.service.ITaskLogService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 定时任务日志 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/taskLog")
@Api(value = "定时任务日志相关", tags = "定时任务日志相关")
public class TaskLogController extends BaseController<ITaskLogService, TaskLog> {
    @RequestMapping(value = Urls.TASK_LOG_RANGE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "根据时间范围分页获取列表", notes = "根据时间范围分页获取列表")
    @ResponseBody
    public ResponseVo<IPage<TaskLog>> list(TaskLogFilterVo taskLogFilterVo, TaskLog entity) {
        //查询列表数据
        QueryWrapper<TaskLog> queryWrapper = new QueryWrapper<>(entity);
        if(taskLogFilterVo.getStartTime() != null && taskLogFilterVo.getEndTime() != null){
            queryWrapper = queryWrapper.between("ct", taskLogFilterVo.getStartTime(), taskLogFilterVo.getEndTime());
        }
        IPage<TaskLog> page = bizService.page(
                new Page<>(taskLogFilterVo.getPageNum(), taskLogFilterVo.getPageSize()),
                queryWrapper
        );

        return new ResponseVo<>(page);
    }
}

