package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.DictData;
import com.xadmin.support.core.service.IDictDataService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 字典数据 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/dictData")
@Api(value = "字典数据相关", tags = "字典数据相关")
public class DictDataController extends BaseController<IDictDataService, DictData> {

}

