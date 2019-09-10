package com.xadmin.common.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtil {
    /**
     * 获取去除重复数据后的集合,根据泛型的hashCode以及equals方法判断是否为相同数据
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> List<T> distinctList(Collection<T> collection){
        if(CollectionUtils.isEmpty(collection)){
            return Collections.emptyList();
        }
        return collection.stream().distinct().collect(Collectors.toList());
    }
}
