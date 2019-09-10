package com.xadmin.common.util;


import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertUtil {
    public static List<Long> splitStr2LongList(String content, String splitChar) {
        if(StringUtils.isEmpty(content)){
            return new ArrayList<>();
        }

        String[] split = content.split(splitChar);
        Long[] longArr = (Long[]) ConvertUtils.convert(split, Long.class);
        // 返回值类型是ArrayList，但此ArrayList是Array的内部类,调用add()时，会报错：java.lang.UnsupportedOperationException;故需要再次构造一个新的ArrayList
        return new ArrayList<>(Arrays.asList(longArr));
    }

    public static String[] splitStr2StrArray(String content, String splitChar) {
        if(StringUtils.isEmpty(content)){
            return new String[]{};
        }

        String[] split = content.split(splitChar);
        return split;
    }

    public static <T, S> List<T> convertList(List<S> sourceList, Class<T> targetClazz){
        if(CollectionUtils.isEmpty(sourceList)){
            return new ArrayList<>();
        }

        return JSON.parseArray(JSON.toJSONString(sourceList), targetClazz);
    }
}
