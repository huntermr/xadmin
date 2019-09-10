package com.xadmin.support.core.service;

import com.xadmin.framework.base.BaseService;
import com.xadmin.support.core.entity.ArticleCategory;
import com.xadmin.support.core.vo.response.ArticleCateVo;

import java.util.List;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IArticleCategoryService extends BaseService<ArticleCategory> {
    boolean save(ArticleCategory articleCategory);

    boolean removeById(Long categoryId);

    boolean updateById(ArticleCategory articleCategory);

    List<ArticleCateVo> getTreeCates();

    List<Long> getCateIdsByParentId(Long cateId);
}
