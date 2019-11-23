package com.zwc.log.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BSayHelloApi
 * @Desc TODO   Say Hello
 * @Date 2019/5/15 15:28
 * @Version 1.0
 */
@RestController
@Api(value = "日志工程", description = "日志工程暴露服务被其他工程调用")
public class BSayHelloApi {

    /*
     * @ClassName BSayHelloApi
     * @Desc TODO   读取配置文件中的端口
     * @Date 2019/5/15 15:49
     * @Version 1.0
     */
    @Value("${server.port}")
    private String port;

    /*
     * @ClassName BSayHelloApi
     * @Desc TODO   Say Hello
     * @Date 2019/5/15 15:30
     * @Version 1.0
     */
    @GetMapping("/b")
    @ApiOperation(value = "日志工程 - 日志工程暴露服务被基础工程调用", produces = MediaType.APPLICATION_JSON_VALUE)
    public String b(){
        return "Hello！I'm b. port：" + port;
    }

}
