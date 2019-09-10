package com.xadmin.admin.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xadmin.admin.annotation.OpLog;
import com.xadmin.admin.enums.OpType;
import com.xadmin.framework.constants.Constants;
import com.xadmin.framework.utils.NetworkUtils;
import com.xadmin.support.core.entity.OperationLog;
import com.xadmin.support.core.service.IOperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

/**
 * 操作日志记录处理
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class OpLogAspect
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOperationLogService operationLogService;

    // 配置织入点
    @Pointcut("@annotation(com.xadmin.admin.annotation.OpLog)")
    public void logPointCut(){}

    @AfterReturning(pointcut = "logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint)
    {
        handleLog(joinPoint, null);
    }

    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e);
    }

    private void handleLog(final JoinPoint joinPoint, final Exception e){
        try{
            OpLog opLog = getAnnotationLog(joinPoint);
            if (opLog == null){
                return;
            }

            // 开始填充操作日志
            OperationLog operationLog = new OperationLog();

            String description = opLog.description();
            OpType opType = opLog.opType();
            boolean saveParams = opLog.isSaveParams();

            operationLog.setOperationContent(description);
            operationLog.setOperationType(opType.ordinal());

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String remoteIP = NetworkUtils.getIpAddr(request);
            String url = request.getRequestURL().toString();
            String method = request.getMethod();

            operationLog.setOperationIp(remoteIP);
            operationLog.setOperationUri(url);
            operationLog.setOperationTime(new Date());
            operationLog.setOperationMethod(method);

            String userId = request.getHeader(Constants.HEADER_USER_ID);
            if(!StringUtils.isEmpty(userId) && org.apache.commons.lang.StringUtils.isNumeric(userId)){
                operationLog.setUserId(Long.parseLong(userId));
            }

            String source = request.getHeader(Constants.HEADER_SOURCE);
            if(!StringUtils.isEmpty(source)){
                operationLog.setOperationDevice(source);
            }

            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            // 通过这获取到方法的所有参数名称的字符串数组
            String[] parameterNames = methodSignature.getParameterNames();

            if(saveParams){
                Object[] args = joinPoint.getArgs();
                JSONObject jsonObject = new JSONObject();
                if (args != null) {
                    for (int i = 0; i< args.length; i++) {
                        Object obj = args[i];
                        String parameterName = parameterNames[i];
                        if (obj != null) {
                            jsonObject.put(parameterName, obj);
                        }
                    }
                }
                operationLog.setOperationParams(jsonObject.toString());
            }

            operationLogService.asyncSave(operationLog);

        }catch (Exception ex){
            logger.error("处理操作日志时发生异常:{}", ex.getMessage());
        }
    }

    private OpLog getAnnotationLog(JoinPoint joinPoint) throws Exception{
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null){
            return method.getAnnotation(OpLog.class);
        }
        return null;
    }
}
