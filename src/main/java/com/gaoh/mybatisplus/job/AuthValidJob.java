package com.gaoh.mybatisplus.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @description 授权校验定时任务
 * @author gaoh
 * @Date 20190813
 *
 */
@Component
@Slf4j
public class AuthValidJob {


    //    @Scheduled(cron = "59 59 23 * * ? ")
    //每分钟执行一次
//    @Scheduled(cron = "0 0/1 * * * ? ")
    @Transactional(rollbackFor = { Exception.class })
    public void execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA);// 输出北京时间
        log.info(AuthValidJob.class.getName() + "  " + sdf.format(new Date(System.currentTimeMillis())));
    }


}
