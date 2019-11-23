package com.zwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
  * @ClassName OscRegistryServiceApplication
  * @Desc TODO  注册中心启动类
  * @Date 2019/11/1 11:12 AM
  * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class OscRegistryServiceApplication {

    private static final String[] BANNER = new String[]{
            "-------------------------------------",
            "佛祖保佑       永不宕机       永无BUG",
            "-------------------------------------"
    };

    public static void main(String[] args) {
        for (String line : BANNER) {
            System.out.println(line);
        }
        SpringApplication.run(OscRegistryServiceApplication.class, args);
    }

}
