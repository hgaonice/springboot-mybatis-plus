package com.gaoh.mybatisplus.config;

import com.gaoh.mybatisplus.service.impl.SysJobServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/14 16:06
 */
@Configuration
@EnableScheduling
public class schedulerConfig {

    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setConfigLocation(new ClassPathResource("quartz.properties"));
        scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        return scheduler;
    }

    @Bean(initMethod = "initJob")
    public SysJobServiceImpl sysJobService() {
       return new SysJobServiceImpl();
    }


}
