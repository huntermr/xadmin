package com.xadmin.quartz.vo;

import com.xadmin.quartz.constants.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OptTaskInfo {
    @ApiModelProperty(value = "任务类(全限定类名)", required = true)
    private String jobClassName;
    @ApiModelProperty(value = "任务名称", required = true)
    private String jobName;
    @ApiModelProperty(value = "任务分组key", required = true)
    private String jobGroup;
    @ApiModelProperty(value = "补偿机制, 1 立即执行所有错过的任务 2 错过的任务只执行一次 3 舍弃错过的任务(默认)")
    private Integer misfire = Constants.MISFIRE_DO_NOTHING;
    @ApiModelProperty(value = "任务表达式", required = true)
    private String cronExpression;
    @ApiModelProperty(value = "任务描述")
    private String jobDescription;

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public Integer getMisfire() {
        return misfire;
    }

    public void setMisfire(Integer misfire) {
        this.misfire = misfire;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}
