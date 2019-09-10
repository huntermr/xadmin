package com.xadmin.admin.controller.rest;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.support.core.entity.Ads;
import com.xadmin.support.core.service.IAdsService;
import io.swagger.annotations.Api;


/**
 * <p>
 * 广告轮播 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/ads")
@Api(value = "广告轮播相关", tags = "广告轮播相关")
public class AdsController extends BaseController<IAdsService, Ads> {

}

