package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.LoginLog;
import com.xadmin.support.core.service.ILoginLogService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 登录日志 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/loginLog")
@Api(value = "登录日志相关", tags = "登录日志相关")
public class LoginLogController extends BaseController<ILoginLogService, LoginLog> {

}

