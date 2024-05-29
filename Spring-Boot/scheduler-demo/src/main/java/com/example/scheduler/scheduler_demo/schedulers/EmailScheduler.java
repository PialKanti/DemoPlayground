package com.example.scheduler.scheduler_demo.schedulers;

import com.example.scheduler.scheduler_demo.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailScheduler {
    @Scheduled(fixedRate = 1000)
    @Async("asyncTaskExecutor")
    public void sendEmail() {
        log.info("[EmailScheduler][SendEmail][{}] Job started at {}", Thread.currentThread().getName(), DateTimeUtil.getCurrentFormattedDateTime());
    }
}
