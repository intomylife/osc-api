package com.zwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/*
  * @ClassName OscSleuthServiceApplication
  * @Desc TODO  链路跟踪监控中心启动类
  * @Date 2019/11/1 3:57 PM
  * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class OscSleuthServiceApplication {

    private static final String[] BANNER = new String[]{
            "-------------------------------------",
            "佛祖保佑       永不宕机       永无BUG",
            "-------------------------------------"
    };

    public static void main(String[] args) {
        for (String line : BANNER) {
            System.out.println(line);
        }
        SpringApplication.run(OscSleuthServiceApplication.class, args);
    }

}
