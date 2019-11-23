package com.zwc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
  * @ClassName OscTurbineServiceApplication
  * @Desc TODO  断路器聚合监控中心启动类
  * @Date 2019/11/1 3:36 PM
  * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class OscTurbineServiceApplication {

    private static final String[] BANNER = new String[]{
            "-------------------------------------",
            "佛祖保佑       永不宕机       永无BUG",
            "-------------------------------------"
    };

    public static void main(String[] args) {
        for (String line : BANNER) {
            System.out.println(line);
        }
        SpringApplication.run(OscTurbineServiceApplication.class, args);
    }

}
