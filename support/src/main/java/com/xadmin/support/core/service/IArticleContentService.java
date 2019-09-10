package com.xadmin.support.core.service;

import com.xadmin.support.core.entity.ArticleContent;
import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.vo.response.ArticleVo;

/**
 * <p>
 * 文章内容 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IArticleContentService extends BaseService<ArticleContent> {
    ArticleContent getByActicleId(Long acticleId);
}
