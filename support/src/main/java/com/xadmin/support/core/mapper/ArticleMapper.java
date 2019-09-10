package com.xadmin.support.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.support.core.entity.Article;
import com.xadmin.support.core.vo.request.ArticleFilterVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章信息 Mapper 接口
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface ArticleMapper extends BaseMapper<Article> {
    IPage<Article> getArticleList(Page page, @Param("param") ArticleFilterVo filterVo);
}
