package com.xadmin.framework.constants;

/**
 * 用于管理通用微服务Url
 */

public interface Urls {
    String BASE_ADD_HTML = "/add";
    String BASE_GET_HTML = "/info/{id}";
    String BASE_UPDATE_HTML = "/update/{id}";
    String BASE_DELETE_HTML = "/delete/{id}";
    String BASE_LIST_HTML = "/view/all";
    String BASE_PAGE_LIST_HTML = "/view/page";

    String BASE_ADD = "";
    String BASE_GET = "/{id}";
    String BASE_UPDATE = "";
    String BASE_DELETE = "/{id}";
    String BASE_LIST = "/all";
    String BASE_PAGE_LIST = "/page";

}
