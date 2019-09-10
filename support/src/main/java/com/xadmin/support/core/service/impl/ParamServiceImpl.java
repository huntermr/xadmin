package com.xadmin.support.core.service.impl;

import com.xadmin.support.core.constants.SystemErrorCode;
import com.xadmin.support.core.entity.Param;
import com.xadmin.support.core.exception.SystemException;
import com.xadmin.support.core.mapper.ParamMapper;
import com.xadmin.support.core.service.IParamService;
import com.xadmin.framework.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 系统参数 服务实现类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
@Service
public class ParamServiceImpl extends BaseServiceImpl<ParamMapper, Param> implements IParamService {
    @Override
    public boolean removeById(Serializable id) {
        Param param = getById(id);
        if(param.getSystemFlag()){
            throw new SystemException(SystemErrorCode.SYSTEM_PARAM_CANNOT_DELETE_ERROR.getCode());
        }

        return super.removeById(id);
    }
}
