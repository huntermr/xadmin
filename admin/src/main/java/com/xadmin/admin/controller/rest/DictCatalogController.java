package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.DictCatalog;
import com.xadmin.support.core.service.IDictCatalogService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 字典目录 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/dictCatalog")
@Api(value = "字典目录相关", tags = "字典目录相关")
public class DictCatalogController extends BaseController<IDictCatalogService, DictCatalog> {

}

