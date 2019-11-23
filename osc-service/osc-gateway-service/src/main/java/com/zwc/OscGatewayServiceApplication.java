package com.zwc;

import com.zwc.gateway.config.TokenFilter;
import com.zwc.gateway.config.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/*
  * @ClassName OscGatewayServiceApplication
  * @Desc TODO  服务网关启动类
  * @Date 2019/11/1 2:05 PM
  * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class OscGatewayServiceApplication {

    private static final String[] BANNER = new String[]{
            "-------------------------------------",
            "佛祖保佑       永不宕机       永无BUG",
            "-------------------------------------"
    };

    public static void main(String[] args) {
        for (String line : BANNER) {
            System.out.println(line);
        }
        SpringApplication.run(OscGatewayServiceApplication.class, args);
    }

    /*
     * @ClassName SpringcloudGatewayMasterServiceApplication
     * @Desc TODO   配置限流 Bean
     * @Date 2019/6/29 17:12
     * @Version 1.0
     */
    @Bean(name = "uriKeyResolver")
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    /*
     * @ClassName SpringcloudGatewayMasterServiceApplication
     * @Desc TODO   配置认证过滤器 Bean
     * @Date 2019/6/29 17:58
     * @Version 1.0
     */
    @Bean(name = "tokenFilter")
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
