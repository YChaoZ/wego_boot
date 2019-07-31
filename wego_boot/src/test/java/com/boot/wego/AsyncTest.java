package com.boot.wego;

import com.boot.wego.util.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTest {
    @Autowired
    AsyncTask asyncTask;

    @Test
    public void contextLoads() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future task1 = asyncTask.task1();
        Future task2 = asyncTask.task2();
        Future task3 = asyncTask.task3();

        while (true){
            System.out.println("测试任务进行中");
            if (task1.isDone() && task2.isDone() && task3.isDone() ){
                System.out.println("任务完成！");
                break;
            }

            System.out.println("测试任务执行中");
            Thread.sleep(10);
        }

        long end = System.currentTimeMillis();
        System.out.println("测试完成,执行时间为：" + (end-start));
    }
}
