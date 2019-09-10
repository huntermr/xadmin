package com.xadmin.framework.aspect;

import com.alibaba.fastjson.JSON;
import com.xadmin.framework.utils.NetworkUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018/2/2.
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.xadmin..*.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        String headers = JSON.toJSONString(headerNames);

        String queryString = request.getQueryString();

        StringBuilder params = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (Object obj : args) {
                if (obj != null) {
                    if(obj instanceof MultipartFile){
                        params.append(String.format("上传文件,名称%s,文件大小%d", ((MultipartFile) obj).getOriginalFilename(), ((MultipartFile) obj).getSize()));
                    }else{
                        params.append(JSON.toJSONString(obj));
                    }
                    params.append(",");
                }
            }
        }

        // 记录下请求内容
        logger.info("-------------请求信息开始--------------");
        logger.info(String.format("发起请求的IP:%1$s", NetworkUtils.getIpAddr(request)));
        logger.info(String.format("请求Url:%1$s", request.getRequestURL().toString()));
        logger.info(String.format("请求方式:%1$s", request.getMethod()));
        logger.info(String.format("请求头:%1$s", headers));
        logger.info(String.format("请求参数:%1$s", params.toString()));
        logger.info("-------------请求信息结束--------------");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 记录下响应内容
        logger.info("-------------响应信息开始--------------");
        logger.info(String.format("response info: %1$s ",
                JSON.toJSONString(ret)
        ));
        logger.info("-------------响应信息结束--------------");
        logger.info("===================================================");
    }

}
