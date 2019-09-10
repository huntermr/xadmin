package com.xadmin.admin.constants;

public interface Urls {
    //root
    String ROOT = "/v1";

    String USER_MODULE = ROOT + "/user";
    String ROLE_MODULE = ROOT + "/role";
    String RESOURCE_MODULE = ROOT + "/resource";
    String ADS_MODULE = ROOT + "/ads";
    String NAV_MODULE = ROOT + "/nav";
    String ARTICLE_MODULE = ROOT + "/article";
    String COMMON_MODULE = ROOT + "/common";
    String DEPT_MODULE = ROOT + "/dept";

    String USER_LOGIN = "/login";
    String USER_LOGOUT = "/logout/{userId}";
    String USER_ADD = "";
    String USER_UPDATE = "/{userId}";
    String USER_RESET_PWD = "/reset";
    String USER_LIST = "/page";
    String USER_ALL = "/all";
    String USER_LIST_BY_GROUP = "/group/{groupId}/list";
    String USER_INFO = "/{userId}";
    String USER_DELETE = "/{userId}";
    String USER_CHANGE_LOCK = "/lock/{userId}";
    String USER_AUTH_CACHE = "/authcache/{userId}";

    String ROLE_LIST_BY_USER = "/{userId}/list";
    String ROLE_LIST_BY_GROUP = "/group/{groupId}/list";
    String ROLE_LIST = "/page";
    String ROLE_ALL = "/all";
    String ROLE_ADD = "";
    String ROLE_UPDATE = "/{roleId}";
    String ROLE_DELETE = "/{roleId}";
    String ROLE_INFO = "/{roleId}";
    String ROLE_USER_BIND = "/bind/{userId}";

    String USER_GROUP_BIND = "/bind/user/{groupId}";
    String USER_GROUP_ROLE_BIND = "/bind/role/{groupId}";

    String RESOURCE_LIST_BY_USER = "/{userId}/list";
    String RESOURCE_LIST_BY_ROLE = "/role/{roleId}/list";
    String RESOURCE_LIST = "/list";
    String RESOURCE_UPDATE = "/{resourceId}";
    String RESOURCE_DELETE = "/{resourceId}";
    String RESOURCE_ADD = "";
    String RESOURCE_INFO = "/{resourceId}";
    String RESOURCE_USER_BIND = "/bind/{roleId}";

    String COMMON_UPLOAD = "/upload";

    String ADS_LIST = "/list";
    String ADS_INFO = "/{adsId}";
    String ADS_ADD = "";
    String ADS_UPDATE = "/{adsId}";
    String ADS_DELETE = "/{adsId}";

    String DEPT_LIST_BY_USER = "/{userId}/list";
    String DEPT_LIST = "/list";
    String DEPT_USER_BIND = "/bind/{userId}";

    String CATE_TREE_LIST = "/tree";

    String ARTICLE_INFO = "/{articleId}";
    String ARTICLE_PAGE = "/pages";
    String ARTICLE_ADD = "";
    String ARTICLE_UPDATE = "/{articleId}";
    String ARTICLE_DELETE = "/{articleId}";

    String TASK_LOG_RANGE_LIST = "/range";
}
