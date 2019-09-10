package com.xadmin.support.core.service.impl;

import com.xadmin.framework.base.BaseServiceImpl;
import com.xadmin.support.core.constants.ArticleErrorCode;
import com.xadmin.support.core.entity.ArticleCategory;
import com.xadmin.support.core.exception.ArticleException;
import com.xadmin.support.core.mapper.ArticleCategoryMapper;
import com.xadmin.support.core.service.IArticleCategoryService;
import com.xadmin.support.core.vo.response.ArticleCateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class ArticleCategoryServiceImpl extends BaseServiceImpl<ArticleCategoryMapper, ArticleCategory> implements IArticleCategoryService {

    @Override
    public boolean save(ArticleCategory articleCategory) {
        // 添加前填充分类等级字段
        Long parentCategoryId = articleCategory.getParentCategoryId();
        if(parentCategoryId != null){
            ArticleCategory parentCate = getById(parentCategoryId);
            if(parentCate == null){
                throw new ArticleException(ArticleErrorCode.ARTICLE_PARENT_CATE_NOT_EXIST_ERROR.getCode());
            }

            Integer parentCateCategoryLevel = parentCate.getCategoryLevel();
            if(parentCateCategoryLevel != null){
                articleCategory.setCategoryLevel(parentCateCategoryLevel + 1);
            }
        }

        return super.save(articleCategory);
    }

    @Override
    public boolean removeById(Long categoryId) {
        List<Long> cateIdsByParentId = getCateIdsByParentId(categoryId);
        if(!CollectionUtils.isEmpty(cateIdsByParentId)){
            throw new ArticleException(ArticleErrorCode.ARTICLE_CATE_CANNOT_DEL_ERROR.getCode());
        }

        return super.removeById(categoryId);
    }

    @Override
    public boolean updateById(ArticleCategory articleCategory) {

        Long articleCategoryId = articleCategory.getArticleCategoryId();
        Long parentCategoryId = articleCategory.getParentCategoryId();

        ArticleCategory category = getById(articleCategoryId);
        if(category == null){
            throw new ArticleException(ArticleErrorCode.ARTICLE_CATE_NOT_EXIST_ERROR.getCode());
        }

        if(parentCategoryId != null){
            // 父级分类不能为自己
            if(articleCategoryId.equals(parentCategoryId)){
                throw new ArticleException(ArticleErrorCode.ARTICLE_CANNOT_SELF_ERROR.getCode());
            }

            ArticleCategory parentCate = getById(parentCategoryId);
            if(parentCate == null){
                throw new ArticleException(ArticleErrorCode.ARTICLE_PARENT_CATE_NOT_EXIST_ERROR.getCode());
            }
            Integer parentCateCategoryLevel = parentCate.getCategoryLevel();
            if(parentCateCategoryLevel != null){
                if(category.getCategoryLevel() < parentCateCategoryLevel){
                    throw new ArticleException(ArticleErrorCode.ARTICLE_CATE_LEVEL_ERROR.getCode());
                }
                articleCategory.setCategoryLevel(parentCateCategoryLevel + 1);
            }
        } else {
            articleCategory.setCategoryLevel(0);
        }

        return super.updateById(articleCategory);
    }

    @Override
    public List<ArticleCateVo> getTreeCates() {
        List<ArticleCategory> categories = list();

        return convertTreeCates(categories);
    }

    /**
     * 根据父分类ID获取所有子分类ID
     * @param parentId
     * @return
     */
    @Override
    public List<Long> getCateIdsByParentId(Long parentId) {
        List<ArticleCategory> categories = list();

        return getChildTreeCateIds(categories, parentId);
    }

    /**
     * 将一组分类数据转换为树状结构的数据
     * @param categories
     * @return
     */
    private List<ArticleCateVo> convertTreeCates(List<ArticleCategory> categories){
        List<ArticleCateVo> cateVos = new ArrayList<>();

        // 筛选出顶级资源,剩余的资源皆为非顶级资源
        if(!CollectionUtils.isEmpty(categories)){
            Iterator<ArticleCategory> iterator = categories.iterator();
            while (iterator.hasNext()){
                ArticleCategory category = iterator.next();
                Long parentCategoryId = category.getParentCategoryId();
                if(parentCategoryId == null || parentCategoryId == 0){
                    ArticleCateVo articleCateVo = new ArticleCateVo();
                    BeanUtils.copyProperties(category, articleCateVo);
                    articleCateVo.setChildCates(getChildTreeCates(categories, category.getArticleCategoryId()));
                    cateVos.add(articleCateVo);
                    iterator.remove();
                }
            }
        }

        return cateVos;
    }

    /**
     * 获取指定父分类ID的数据
     * @param categories
     * @param parentCategoryId
     * @return
     */
    private List<ArticleCateVo> getChildTreeCates(List<ArticleCategory> categories, Long parentCategoryId){
        if(CollectionUtils.isEmpty(categories)){
            return null;
        }

        List<ArticleCateVo> treeCates = new ArrayList<>();

        for (ArticleCategory articleCategory : categories) {
            Long categoryId = articleCategory.getArticleCategoryId();
            Long childParentCategoryId = articleCategory.getParentCategoryId();
            if (childParentCategoryId != null && childParentCategoryId.equals(parentCategoryId)) {
                ArticleCateVo cateVo = new ArticleCateVo();
                BeanUtils.copyProperties(articleCategory, cateVo);
                cateVo.setChildCates(getChildTreeCates(categories, categoryId));
                treeCates.add(cateVo);
            }
        }

        return treeCates;
    }

    private List<Long> getChildTreeCateIds(List<ArticleCategory> categories, Long parentCateId){
        if(CollectionUtils.isEmpty(categories)){
            return null;
        }

        List<Long> treeCateIds = new ArrayList<>();

        for (ArticleCategory category : categories) {
            Long cateId = category.getArticleCategoryId();
            Long childParentCateId = category.getParentCategoryId();
            if (childParentCateId != null && childParentCateId.equals(parentCateId)) {
                treeCateIds.add(cateId);

                List<Long> childTreeCateIds = getChildTreeCateIds(categories, cateId);
                if(!CollectionUtils.isEmpty(childTreeCateIds)){
                    treeCateIds.addAll(childTreeCateIds);
                }
            }
        }

        return treeCateIds;
    }
}
