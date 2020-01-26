package com.zwc.base.feign;

import com.zwc.base.feign.fallback.FeignApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @ClassName FeignApi
 * @Desc TODO   使用 Feign 调用 b - 接口
 * @Date 2019/5/20 23:21
 * @Version 1.0
 */
@FeignClient(value = "log-service-core" , fallback = FeignApiFallBack.class)
public interface FeignApi {

    /*
     * @ClassName FeignApi
     * @Desc TODO   通过 log-service-core 服务名调用 b() 方法
     * @Date 2019/5/20 23:21
     * @Version 1.0
     */
    @RequestMapping("/b")
    String b();

}
