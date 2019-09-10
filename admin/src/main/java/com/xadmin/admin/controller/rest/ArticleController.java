package com.xadmin.admin.controller.rest;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.admin.constants.Urls;
import com.xadmin.framework.constants.Constants;
import com.xadmin.framework.vo.ResponseVo;
import com.xadmin.support.core.entity.Article;
import com.xadmin.support.core.entity.User;
import com.xadmin.support.core.service.IArticleService;
import com.xadmin.support.core.service.IUserService;
import com.xadmin.support.core.vo.request.ArticleFilterVo;
import com.xadmin.support.core.vo.request.UpdateArticleVo;
import com.xadmin.support.core.vo.response.ArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * <p>
 * 文章信息 前端控制器
 * </p>
 *
 * @author Ht
 * @since 2019-07-16
 */
@RestController
@RequestMapping(Urls.ARTICLE_MODULE)
@Api(value = "文章信息相关", tags = "文章信息相关")
public class ArticleController {

    @Autowired
    private IArticleService bizService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = Urls.ARTICLE_ADD, method = RequestMethod.POST)
    @ApiOperation(value = "添加文章", notes = "添加文章")
    @ResponseBody
    public ResponseVo add(@RequestHeader(Constants.HEADER_USER_ID) Long userId, UpdateArticleVo articleVo) {
        if(userId != null){
            User userInfo = userService.getById(userId);
            articleVo.setAuthorId(userId);
            articleVo.setAuthorName(userInfo.getUserName());
        }
        bizService.addInfo(articleVo);
        return new ResponseVo();
    }

    @RequestMapping(value = Urls.ARTICLE_UPDATE, method = RequestMethod.PUT)
    @ApiOperation(value = "更新指定ID的文章信息", notes = "更新指定ID的文章信息")
    @ResponseBody
    public ResponseVo update(@PathVariable Long articleId, UpdateArticleVo articleVo) {
        bizService.updateInfo(articleId, articleVo);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ARTICLE_DELETE, method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定ID的文章", notes = "删除指定ID的文章")
    @ResponseBody
    public ResponseVo remove(@PathVariable Long articleId) {
        bizService.removeById(articleId);
        return new ResponseVo<>();
    }

    @RequestMapping(value = Urls.ARTICLE_INFO, method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取文章详情", notes = "根据id获取文章详情")
    @ResponseBody
    public ResponseVo<ArticleVo> getInfo(@PathVariable("articleId") Long articleId) {
        ArticleVo articleVo = bizService.getInfo(articleId);
        return new ResponseVo<>(articleVo);
    }

    @RequestMapping(value = Urls.ARTICLE_PAGE, method = RequestMethod.GET)
    @ApiOperation(value = "根据筛选条件分页获取文章列表", notes = "根据筛选条件分页获取文章列表")
    public ResponseVo<IPage<Article>> getArticleList(ArticleFilterVo filterVo) {
        return new ResponseVo<>(bizService.getArticleList(filterVo));
    }
}

