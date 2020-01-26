package com.zwc.base.controller;

import com.zwc.base.feign.FeignApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @ClassName AUseBFeignController
 * @Desc TODO   使用 Feign 调用 b - 前端控制器
 * @Date 2019/5/20 23:23
 * @Version 1.0
 */
@RestController
@Api(value = "基础工程", description = "基础工程调用其他工程")
public class AUseBFeignController {

    @Autowired(required = false)
    private FeignApi feignApi;

    /*
     * @ClassName FeignController
     * @Desc TODO   通过 log-service-core 服务名调用 b() 方法
     * @Date 2019/5/20 23:13
     * @Version 1.0
     */
    @GetMapping("/aUseB")
    @ApiOperation(value = "基础工程 - 基础工程调用日志工程", produces = MediaType.APPLICATION_JSON_VALUE)
    public String aUseB(){
        return feignApi.b();
    }

}
