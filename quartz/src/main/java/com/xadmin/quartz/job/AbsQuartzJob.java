package com.xadmin.quartz.job;

import com.xadmin.support.core.constants.CoreConstants;
import com.xadmin.support.core.entity.TaskLog;
import com.xadmin.support.core.service.ITaskLogService;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 定时任务基类,用于统一记录任务执行状态等数据
 * 默认允许并发执行,如需非并发执行,请继承{@link DisallowConcurrentQuartzJob}
 */
public abstract class AbsQuartzJob implements Job {
    @Autowired
    private ITaskLogService taskLogService;

    private Logger logger = LoggerFactory.getLogger(AbsQuartzJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        String jobName = jobDetail.getKey().getName();
        String jobGroup = jobDetail.getKey().getGroup();
        String jobDesc = jobDetail.getDescription();

        TaskLog taskLog = new TaskLog();
        taskLog.setTaskName(jobName);
        taskLog.setTaskGroup(jobGroup);
        taskLog.setTaskDesc(jobDesc);
        taskLog.setTaskStatus(CoreConstants.TASK_STATUS_NOMARL);

        try {
            before(jobExecutionContext);
            executeJob(jobExecutionContext);
            after(jobExecutionContext);
        }catch (Exception ex){
            taskLog.setTaskStatus(CoreConstants.TASK_STATUS_ERROR);
            // 获取详细异常信息
            StringWriter stringWriter= new StringWriter();
            PrintWriter writer= new PrintWriter(stringWriter);
            ex.printStackTrace(writer);
            StringBuffer buffer= stringWriter.getBuffer();
            taskLog.setExceptionInfo(buffer.toString());
        }finally {
            taskLogService.save(taskLog);
        }
    }

    public void before(JobExecutionContext jobExecutionContext){
        logger.info("准备执行任务:{}, 任务详情:{}", getClass().getName(), jobExecutionContext.getJobDetail());
    }

    public abstract void executeJob(JobExecutionContext jobExecutionContext);

    public void after(JobExecutionContext jobExecutionContext){
        logger.info("任务执行完成:{}, 任务详情:{}", getClass().getName(), jobExecutionContext.getJobDetail());
    }
}
