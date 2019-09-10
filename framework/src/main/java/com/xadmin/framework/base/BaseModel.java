package com.xadmin.framework.base;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Administrator on 2018/1/30.
 */
@JsonIgnoreProperties(value={"ct","ut","isDel","version"})
public abstract class BaseModel<T extends BaseModel> extends Model<T> {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    protected Serializable pkVal() {
        return super.pkVal();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BaseModel model = (BaseModel) o;
//        return pkVal().equals(model.pkVal());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(pkVal());
//    }
}
