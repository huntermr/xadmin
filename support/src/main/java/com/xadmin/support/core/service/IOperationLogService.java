package com.xadmin.support.core.service;

import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.framework.base.BaseService;

/**
 * <p>
 * 操作日志 服务类
 * </p>
 *
 * @author Ht
 * @since 2019-07-15
 */
public interface IOperationLogService extends BaseService<OperationLog> {
    void asyncSave(OperationLog log) throws InterruptedException;
}
