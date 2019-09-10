package com.xadmin.support.core.constants;

/**
 * Created by Administrator on 2018/3/3.
 */
public class CoreConstants {
    // 用户状态标识位
    public static final String USER_LOCK = "L";    //用户锁定
    public static final String USER_NONE = "N";     //用户正常

    // 资源类型标识
    public static final String RESOURCE_GROUP = "G";     //菜单组
    public static final String RESOURCE_MENU = "M";     //菜单
    public static final String RESOURCE_BUTTON = "O";     //按钮

    // 是否为默认值
    public static final Integer IS_DEFAULT_N = 0;     //否
    public static final Integer IS_DEFAULT_Y = 1;     //是

    // 定时任务执行状态
    public static final Integer TASK_STATUS_NOMARL = 0;     //正常
    public static final Integer TASK_STATUS_ERROR = 1;     //异常

    public static final String ALIYUN_OSS_ENDPOINT = "oss-cn-shenzhen.aliyuncs.com";
    public static final String ALIYUN_OSS_BUCKET_URL = "xadmin-resource.oss-cn-shenzhen.aliyuncs.com";
    public static final String ALIYUN_OSS_ACCESSKEYID = "LTAIHx9dTllSoB4X";
    public static final String ALIYUN_OSS_ACCESSKEYSECRET = "g9JbGXgG56ESauWHq3uzSMyNEF6Pph";
    public static final String ALIYUN_OSS_BUCKETNAME = "xadmin-resource";

    public static final String USER_AUTH_CACHE_KEY = "user_auth_%s";
}
