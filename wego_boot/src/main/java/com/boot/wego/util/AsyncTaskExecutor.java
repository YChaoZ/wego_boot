//package com.boot.wego.util;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.ThreadPoolExecutor;
//
//@EnableAsync
//@Configuration
//public class AsyncTaskExecutor {
//    @Bean(name = "asyncTaskExecutor") //此形式2.1不能使用，2.0能正常运行
//    public Executor asyncTaskExecutor(){
//        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
//        threadPoolExecutor.setCorePoolSize(8); //核心线程数
//        threadPoolExecutor.setMaxPoolSize(16); //最大线程池
//        threadPoolExecutor.setKeepAliveSeconds(300); //线程最大空闲时间
//        threadPoolExecutor.setQueueCapacity(40); //队列大小
//        threadPoolExecutor.setThreadNamePrefix("AsyncTaskExecuter-"); //线程前缀
//        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
//
//        // 线程池对拒绝任务的处理策略。在 ThreadPoolExecutor 里面定义了 4 种 handler 策略，分别是
//        // 1. CallerRunsPolicy ：这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功。
//        // 2. AbortPolicy ：对拒绝任务抛弃处理，并且抛出异常。
//        // 3. DiscardPolicy ：对拒绝任务直接无声抛弃，没有异常信息。
//        // 4. DiscardOldestPolicy ：对拒绝任务不抛弃，而是抛弃队列里面等待最久的一个线程，然后把拒绝任务加到队列。
//        return threadPoolExecutor;
//    }
//}
