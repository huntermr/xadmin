package com.xadmin.support.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xadmin.framework.base.BaseServiceImpl;
import com.xadmin.support.core.entity.Article;
import com.xadmin.support.core.entity.ArticleContent;
import com.xadmin.support.core.mapper.ArticleContentMapper;
import com.xadmin.support.core.service.IArticleContentService;
import com.xadmin.support.core.vo.response.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章内容 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class ArticleContentServiceImpl extends BaseServiceImpl<ArticleContentMapper, ArticleContent> implements IArticleContentService {

    @Override
    public ArticleContent getByActicleId(Long acticleId) {
        ArticleContent articleContent = getOne(new QueryWrapper<ArticleContent>().eq("article_id", acticleId));
        return articleContent;
    }
}
