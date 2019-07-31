package com.boot.wego.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public Future task1(){
        System.out.println("任务1开始执行！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务1执行完成！");
        return new AsyncResult("任务1执行完成");
    }

    @Async
    public Future task2(){
        System.out.println("任务2开始执行！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务1执行完成！");
        return new AsyncResult("任务2执行完成");
    }

    @Async
    public Future task3(){
        System.out.println("任务3开始执行！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务1执行完成！");
        return new AsyncResult("任务3执行完成");
    }

//    @Async("asyncTaskExecutor")
//    public Future task4(){
//        System.out.println("任务4开始执行！");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("任务1执行完成！");
//        return new AsyncResult("任务4执行完成");
//    }
}
