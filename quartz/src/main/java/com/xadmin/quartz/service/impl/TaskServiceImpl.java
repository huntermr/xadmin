package com.xadmin.quartz.service.impl;

import com.xadmin.quartz.constants.Constants;
import com.xadmin.quartz.constants.TaskErrorCode;
import com.xadmin.quartz.exception.TaskException;
import com.xadmin.quartz.service.TaskService;
import com.xadmin.quartz.vo.OptTaskInfo;
import com.xadmin.quartz.vo.TaskInfo;
import org.apache.commons.lang.time.DateFormatUtils;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired(required = false)
    private Scheduler scheduler;

    /**
     * 所有任务列表
     */
    @Override
    public List<TaskInfo> list(){
        List<TaskInfo> list = new ArrayList<>();

        try {
            for(String groupJob: scheduler.getJobGroupNames()){
                for(JobKey jobKey: scheduler.getJobKeys(GroupMatcher.<JobKey>groupEquals(groupJob))){
                    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                    for (Trigger trigger: triggers) {
                        Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                        JobDetail jobDetail = scheduler.getJobDetail(jobKey);

                        String cronExpression = "", createTime = "";
                        Integer misfireInstruction = null;

                        if (trigger instanceof CronTrigger) {
                            CronTrigger cronTrigger = (CronTrigger) trigger;
                            cronExpression = cronTrigger.getCronExpression();
                            createTime = cronTrigger.getDescription();
                            misfireInstruction = trigger.getMisfireInstruction();
                        }

                        TaskInfo info = new TaskInfo();
                        info.setJobName(jobKey.getName());
                        info.setJobGroup(jobKey.getGroup());
                        info.setJobDescription(jobDetail.getDescription());
                        info.setJobStatus(triggerState.name());
                        info.setCronExpression(cronExpression);
                        info.setCreateTime(createTime);
                        info.setMisfire(misfireInstruction);
                        info.setJobClassName(jobDetail.getJobClass().getName());
                        list.add(info);
                    }
                }
            }
        } catch (SchedulerException e) {
            logger.error("获取定时任务失败", e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }

        return list;
    }

    /**
     * 保存定时任务
     * @param info
     */
    @Override
    public void addJob(OptTaskInfo info) {
        String  jobClassName = info.getJobClassName(),
                jobName = info.getJobName(),
                jobGroup = info.getJobGroup(),
                cronExpression = info.getCronExpression(),
                jobDescription = info.getJobDescription(),
                createTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        Integer misfire = info.getMisfire();
        try {
            if (checkExists(jobName, jobGroup)) {
                logger.info("add job fail, job already exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
                throw new TaskException(TaskErrorCode.TASK_EXIST_ERROR.getCode());
            }

            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);

            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            cronScheduleBuilder = createCronScheduleMisfirePolicy(misfire, cronScheduleBuilder);

            CronTrigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(triggerKey)
                    .withDescription(createTime)
                    .withSchedule(cronScheduleBuilder)
                    .build();

            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(jobClassName);

            JobDetail jobDetail = JobBuilder
                    .newJob(jobClass)
                    .withIdentity(jobKey)
                    .withDescription(jobDescription)
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            logger.error("添加定时任务失败,exception:{}",e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }
    }

    /**
     * 修改定时任务
     * @param info
     */
    @Override
    public void edit(OptTaskInfo info) {
        String jobName = info.getJobName(),
                jobGroup = info.getJobGroup();
        try {
            if (!checkExists(jobName, jobGroup)) {
                logger.info("edit job fail, job is not exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
                throw new TaskException(TaskErrorCode.TASK_NOT_EXIST_ERROR.getCode());
            }else{
                delete(jobName, jobGroup);
                addJob(info);
            }
        } catch (SchedulerException e) {
            logger.error("修改定时任务失败,exception:{}",e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }
    }

    /**
     * 删除定时任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void delete(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                scheduler.unscheduleJob(triggerKey);
                logger.info("delete job, triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }
    }

    /**
     * 暂停定时任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void pause(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.pauseTrigger(triggerKey);
                logger.info("pause job success, triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }
    }

    /**
     * 重新开始任务
     * @param jobName
     * @param jobGroup
     */
    @Override
    public void resume(String jobName, String jobGroup){
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);

        try {
            if (checkExists(jobName, jobGroup)) {
                scheduler.resumeTrigger(triggerKey);
                logger.info("resume job success,triggerKey:{},jobGroup:{}, jobName:{}", triggerKey ,jobGroup, jobName);
            }
        } catch (SchedulerException e) {
            logger.error(e.getMessage());
            throw new TaskException(TaskErrorCode.TASK_PARAMS_ERROR.getCode());
        }
    }

    /**
     * 验证是否存在
     * @param jobName
     * @param jobGroup
     * @throws SchedulerException
     */
    @Override
    public boolean checkExists(String jobName, String jobGroup) throws SchedulerException{
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        return scheduler.checkExists(triggerKey);
    }

    /**
     * 根据补偿机制构建对应的值
     * @param misfire
     * @param cronScheduleBuilder
     * @return
     */
    private CronScheduleBuilder createCronScheduleMisfirePolicy(int misfire, CronScheduleBuilder cronScheduleBuilder){
        switch (misfire){
            case Constants.MISFIRE_IGNORE:
                return cronScheduleBuilder.withMisfireHandlingInstructionIgnoreMisfires();
            case Constants.MISFIRE_FIRE_AND_PROCEED:
                return cronScheduleBuilder.withMisfireHandlingInstructionFireAndProceed();
            case Constants.MISFIRE_DO_NOTHING:
                return cronScheduleBuilder.withMisfireHandlingInstructionDoNothing();
            default:
                throw new TaskException(TaskErrorCode.TASK_MISFIRE_ERROR.getCode());
        }
    }
}
