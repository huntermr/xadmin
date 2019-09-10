package com.xadmin.admin.controller.rest;


import com.xadmin.admin.constants.Urls;
import com.xadmin.framework.base.controller.BaseController;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.entity.ArticleCategory;
import com.xadmin.support.core.service.IArticleCategoryService;
import com.xadmin.support.core.vo.response.ArticleCateVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 文章分类 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping("/v1/articleCategory")
@Api(value = "文章分类相关", tags = "文章分类相关")
public class ArticleCategoryController extends BaseController<IArticleCategoryService, ArticleCategory> {

    @RequestMapping(value = Urls.CATE_TREE_LIST, method = RequestMethod.GET)
    @ApiOperation(value = "获取树状结构文章分类列表", notes = "获取树状结构文章分类列表")
    public ResponseVo<List<ArticleCateVo>> getTreeCates(){
        List<ArticleCateVo> treeCates = bizService.getTreeCates();
        return new ResponseVo<>(treeCates);
    }
}

