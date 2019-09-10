package com.xadmin.support.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.Article;
import com.xadmin.support.core.vo.request.ArticleFilterVo;
import com.xadmin.support.core.vo.request.UpdateArticleVo;
import com.xadmin.support.core.vo.response.ArticleVo;

/**
 * <p>
 * 文章信息 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IArticleService extends BaseService<Article> {
    void addInfo(UpdateArticleVo articleVo);

    void updateInfo(Long articleId, UpdateArticleVo articleVo);

    ArticleVo getInfo(Long articleId);

    IPage<Article> getArticleList(ArticleFilterVo filterVo);
}
