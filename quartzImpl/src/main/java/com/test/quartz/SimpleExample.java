package com.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * <p>Title: com.test.quartz.SimpleExample</P>
 *
 * @author yl
 * @date 2017/5/2 16:56
 * <p>Company: UBill</p>
 */
public class SimpleExample {

    private static final Logger logger = LoggerFactory.getLogger(SimpleExample.class);
    private static String GROUP_NAME= "TESTGROUP";
    private static String JOB_NAME ="HELLOJOB";
    private Scheduler sched = StdSchedulerFactory.getDefaultScheduler();

    public SimpleExample() throws SchedulerException {
    }

    public Scheduler getSched() {
        return sched;
    }

    public static void main(String[] args) throws SchedulerException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        SimpleExample simpleExample = new SimpleExample();

        //simpleExample.modifyJob("trigger1","group1","0/15 * * * * ?");
        simpleExample.delJob("HELLO","TEST");
        simpleExample.addJob("HELLO","TEST","0/50 * * * * ?", (Class<? extends Job>) Class.forName("com.test.quartz.HelloJob"));
        simpleExample.getSched().shutdown();
    }
    //新增
    public void addJob(String jobName,String groupName,String cronExpression,Class<? extends Job> clazz) throws SchedulerException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobName,groupName).build();
        logger.info(jobDetail.getKey()+"");
        Trigger trigger = newTrigger().withIdentity(jobName,groupName).
                withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).forJob(jobDetail).build();

        logger.info(trigger.getKey()+"");
        sched.scheduleJob(jobDetail,trigger);
    }
    //修改
    public void modifyJob(String jobName,String groupName,String cronExpression) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(jobName,groupName);
        CronTrigger trigger = (CronTrigger)sched.getTrigger(triggerKey);
        if(trigger==null)
            return;
        trigger = trigger.getTriggerBuilder().withIdentity(jobName,groupName).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
        sched.rescheduleJob(triggerKey,trigger);

    }

    //删除任务
    public boolean delJob(String jobName,String groupName) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName,groupName);
        boolean result = false;
        if(sched.checkExists(jobKey)){
            result = sched.deleteJob(jobKey);
        }
        return result;
    }

    //停止任务
    public void pauseJob(String jobName,String groupName) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName,groupName);
        boolean result = false;
        if(sched.checkExists(jobKey)){
            sched.pauseJob(jobKey);
        }
    }

    //停止任务
    public void resumeJob(String jobName,String groupName) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName,groupName);
        boolean result = false;
        if(sched.checkExists(jobKey)){
            sched.resumeJob(jobKey);
        }
    }


}
