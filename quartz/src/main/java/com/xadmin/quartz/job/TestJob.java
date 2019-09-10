package com.xadmin.quartz.job;

import com.alibaba.fastjson.JSON;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("testJob")
public class TestJob extends AbsQuartzJob {

    private Logger logger = LoggerFactory.getLogger(TestJob.class);

    @Override
    public void executeJob(JobExecutionContext jobExecutionContext) {
        logger.info("正在执行任务: TestJob execute:{}", JSON.toJSONString(jobExecutionContext.getJobDetail()));
    }
}
