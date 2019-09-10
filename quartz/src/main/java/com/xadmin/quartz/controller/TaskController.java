package com.xadmin.quartz.controller;


import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.quartz.service.TaskService;
import com.xadmin.quartz.vo.OptTaskInfo;
import com.xadmin.quartz.vo.TaskInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 任务管理
 */
@RestController
@RequestMapping("/task")
@Api(value = "定时任务管理器", tags = "定时任务管理器")
public class TaskController {

    @Autowired(required = false)
    private TaskService taskService;

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取所有任务列表", notes = "获取所有任务列表")
    public ResponseVo<List<TaskInfo>> list() {
        List<TaskInfo> infos = taskService.list();
        return new ResponseVo<>(infos);
    }

    @PostMapping(value = "")
    @ApiOperation(value = "新增定时任务", notes = "新增定时任务")
    public ResponseVo add(OptTaskInfo info) {
        taskService.addJob(info);
        return ResponseVo.ok();
    }

    @PutMapping(value = "")
    @ApiOperation(value = "修改指定任务", notes = "修改指定任务")
    public ResponseVo edit(OptTaskInfo info) {
        taskService.edit(info);
        return ResponseVo.ok();
    }

    @DeleteMapping(value = "{jobGroup}/{jobName}")
    @ApiOperation(value = "删除指定任务", notes = "删除指定任务")
    public ResponseVo delete(@PathVariable String jobGroup, @PathVariable String jobName) {
        taskService.delete(jobName, jobGroup);
        return ResponseVo.ok();
    }

    @PutMapping(value = "pause/{jobGroup}/{jobName}")
    @ApiOperation(value = "暂停指定任务", notes = "暂停指定任务")
    public ResponseVo pause(@PathVariable String jobGroup, @PathVariable String jobName) {
        taskService.pause(jobName, jobGroup);
        return ResponseVo.ok();
    }

    @PutMapping(value = "resume/{jobGroup}/{jobName}")
    @ApiOperation(value = "重新开始指定任务", notes = "重新开始指定任务")
    public ResponseVo resume(@PathVariable String jobGroup, @PathVariable String jobName) {
        taskService.resume(jobName, jobGroup);
        return ResponseVo.ok();
    }
}
