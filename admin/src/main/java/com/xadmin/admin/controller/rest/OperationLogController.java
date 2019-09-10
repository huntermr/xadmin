package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.support.core.service.IOperationLogService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 操作日志 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/operationLog")
@Api(value = "操作日志相关", tags = "操作日志相关")
public class OperationLogController extends BaseController<IOperationLogService, OperationLog> {

}

