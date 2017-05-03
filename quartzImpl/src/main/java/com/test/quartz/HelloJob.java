package com.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>Title: com.test.quartz.HelloJob</P>
 *
 * @author yl
 * @date 2017/5/2 16:56
 * <p>Company: UBill</p>
 */
@Component
public class HelloJob implements Job {
    private  static final org.slf4j.Logger logger = LoggerFactory.getLogger(HelloJob.class);
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Hello"+new Date());
    }
}
