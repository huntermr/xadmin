package com.xadmin.quartz.job;

import org.quartz.DisallowConcurrentExecution;

/**
 * 不允许并发执行的定时任务抽象父类
 * 例：需当前任务执行完成后,再执行下一次任务,则集成此类即可
 */
@DisallowConcurrentExecution
public abstract class DisallowConcurrentQuartzJob extends AbsQuartzJob {
}
