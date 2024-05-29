package com.example.scheduler.scheduler_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SchedulerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerDemoApplication.class, args);
	}

	@Bean(name = "asyncTaskExecutor")
	public ThreadPoolTaskExecutor asyncTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5); // Set the initial number of threads in the pool
		executor.setMaxPoolSize(10); // Set the maximum number of threads in the pool
		executor.setQueueCapacity(25); // Set the queue capacity for holding pending tasks
		executor.setThreadNamePrefix("AsyncTask-"); // Set a prefix for thread names
		executor.initialize();
		return executor;
	}

}
