package com.xadmin.common.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    public static String createSaltMd5(String password) {
        String md5First = DigestUtils.md5Hex(password);
        // 取其中某段字符串作为盐值
        String salt = md5First.substring(1, 11);
        // 开始加盐加密
        return DigestUtils.md5Hex(salt + md5First);
    }
}
