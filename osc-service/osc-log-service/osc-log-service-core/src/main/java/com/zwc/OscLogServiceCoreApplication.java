package com.zwc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
  * @ClassName OscLogServiceCoreApplication
  * @Desc TODO  日志工程启动类
  * @Date 2019/11/2 4:45 PM
  * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zwc")
@MapperScan("com.zwc.log.mapper")
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@EnableScheduling
public class OscLogServiceCoreApplication {

    private static final String[] BANNER = new String[]{
            "-------------------------------------",
            "佛祖保佑       永不宕机       永无BUG",
            "-------------------------------------"
    };

    public static void main(String[] args) {
        for (String line : BANNER) {
            System.out.println(line);
        }
        SpringApplication.run(OscLogServiceCoreApplication.class, args);
    }

}
