package com.boot.wego;

import com.boot.wego.entity.property.HomePeoperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class WegoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WegoApplication.class, args);

        // 读取配置文件
        Binder binder = Binder.get(context.getEnvironment());
        HomePeoperty homePeoperty = binder.bind("home", Bindable.of(HomePeoperty.class)).get();
        System.out.println(homePeoperty.getCity());
    }
}
