package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.Param;
import com.xadmin.support.core.service.IParamService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 系统参数 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/param")
@Api(value = "系统参数相关", tags = "系统参数相关")
public class ParamController extends BaseController<IParamService, Param> {

}

