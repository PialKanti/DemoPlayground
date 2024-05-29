package com.example.scheduler.scheduler_demo.schedulers;

import com.example.scheduler.scheduler_demo.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DBScheduler {
    @Async("asyncTaskExecutor")
    @Scheduled(fixedRate = 3000)
    public void fetchDataFromDB() throws InterruptedException {
        log.info("[DBScheduler][FetchDataFromDB][{}] Job started at {}", Thread.currentThread().getName(), DateTimeUtil.getCurrentFormattedDateTime());
        Thread.sleep(10000);
    }
}
