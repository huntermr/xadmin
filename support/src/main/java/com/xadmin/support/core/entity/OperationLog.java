package com.xadmin.support.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.xadmin.framework.base.BaseModel;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author Ht
 * @since 2019-07-18
 */
@TableName("core_operation_log")
@ApiModel(value="OperationLog对象", description="操作日志")
public class OperationLog extends BaseModel<OperationLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "log_id", type = IdType.AUTO)
    private Long logId;

    @ApiModelProperty(value = "操作用户ID")
    private Long userId;

    @ApiModelProperty(value = "操作用户名")
    private String username;

    @ApiModelProperty(value = "操作内容")
    private String operationContent;

    @ApiModelProperty(value = "操作时间")
    private Date operationTime;

    @ApiModelProperty(value = "操作ip")
    private String operationIp;

    @ApiModelProperty(value = "操作请求地址")
    private String operationUri;

    @ApiModelProperty(value = "操作请求方式")
    private String operationMethod;

    @ApiModelProperty(value = "操作类型")
    private Integer operationType;

    @ApiModelProperty(value = "操作请求参数json")
    private String operationParams;

    @ApiModelProperty(value = "操作设备")
    private String operationDevice;

    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(fill = FieldFill.INSERT)
    private Date ct;

    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date ut;

    @ApiModelProperty(value = "删除标识位 0 未删除  1 已删除", hidden = true)
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "乐观锁标识", hidden = true)
    @Version
    private Long version;


    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp;
    }

    public String getOperationUri() {
        return operationUri;
    }

    public void setOperationUri(String operationUri) {
        this.operationUri = operationUri;
    }

    public String getOperationMethod() {
        return operationMethod;
    }

    public void setOperationMethod(String operationMethod) {
        this.operationMethod = operationMethod;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getOperationParams() {
        return operationParams;
    }

    public void setOperationParams(String operationParams) {
        this.operationParams = operationParams;
    }

    public String getOperationDevice() {
        return operationDevice;
    }

    public void setOperationDevice(String operationDevice) {
        this.operationDevice = operationDevice;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.logId;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
        "logId=" + logId +
        ", userId=" + userId +
        ", username=" + username +
        ", operationContent=" + operationContent +
        ", operationTime=" + operationTime +
        ", operationIp=" + operationIp +
        ", operationUri=" + operationUri +
        ", operationMethod=" + operationMethod +
        ", operationType=" + operationType +
        ", operationParams=" + operationParams +
        ", operationDevice=" + operationDevice +
        ", ct=" + ct +
        ", ut=" + ut +
        ", isDel=" + isDel +
        ", version=" + version +
        "}";
    }
}
