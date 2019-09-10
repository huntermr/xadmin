package com.xadmin.quartz.constants;

public class Constants {

    /** 立即执行所有错过的任务 */
    public static final int MISFIRE_IGNORE = -1;
    /** 错过的任务只执行一次 */
    public static final int MISFIRE_FIRE_AND_PROCEED = 1;
    /** 舍弃错过的任务 */
    public static final int MISFIRE_DO_NOTHING = 2;
}
