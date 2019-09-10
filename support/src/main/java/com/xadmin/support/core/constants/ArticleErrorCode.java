/*
 * Copyright © 2019 xadmin
 * xadmin
 * xadmin.com
 * All rights reserved.
 */
package com.xadmin.support.core.constants;

/**
 * Copyright (C), 2015-2019, xadmin
 * FileName: UserErrorCode
 * Author:   Ht
 * Date:     2019/1/31 15:28
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public enum ArticleErrorCode {
    ARTICLE_NOT_EXIST_ERROR(21000, "该文章不存在"),
    ARTICLE_CATE_NOT_EXIST_ERROR(21001, "该分类不存在"),
    ARTICLE_PARENT_CATE_NOT_EXIST_ERROR(21002, "该父级分类不存在"),
    ARTICLE_CATE_CANNOT_DEL_ERROR(21003, "该分类存在下级分类,不可删除"),
    ARTICLE_CATE_LEVEL_ERROR(21004, "不可选择下级作为父级分类"),
    ARTICLE_CANNOT_SELF_ERROR(21005, "父级分类不能为自己"),

    // 各业务服务使用从2xxxx - 8xxxx的状态码
    ;

    private final int code;
    private final String desc;

    ArticleErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static final String fromValue(int value) {
        for (ArticleErrorCode e : values()) {
            if (e.code == value) {
                return e.getDesc();
            }
        }
        return null;
    }
}
