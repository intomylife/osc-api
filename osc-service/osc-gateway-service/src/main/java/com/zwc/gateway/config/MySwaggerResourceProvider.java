package com.zwc.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.*;

/**
 * @ClassName MySwaggerResourceProvider
 * @Desc TODO   聚合 Swagger
 * @Date 2020/1/26 5:36 PM
 * @Version 1.0
 */
@Component
public class MySwaggerResourceProvider implements SwaggerResourcesProvider {

    /**
     * 特定服务名称后缀
     */
    public static final String SERVICE_SUFFIX = "core";

    /**
     * 固定地址
     */
    public static final String FIXED_URL = "/v2/api-docs";

    /**
     * 网关路由
     */
    private final RouteLocator routeLocator;

    @Autowired(required = false)
    public MySwaggerResourceProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {
        // 返回结果
        List<SwaggerResource> resources = new ArrayList<>();
        // 所有路由
        List<String> routeHosts = new ArrayList<>();
        // 过滤并添加路由（只加载指定服务：如处理业务逻辑的服务）
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> route.getUri().getHost().indexOf(SERVICE_SUFFIX.toUpperCase()) != -1)
                .subscribe(route -> routeHosts.add(route.getUri().getHost()));

        // 去重已添加的地址
        Set<String> dealed = new HashSet<>();
        // 遍历所有路由
        routeHosts.forEach(instance -> {
            // 拼接地址，格式为：/ + 路由 + 固定地址
            String url = "/" + instance + FIXED_URL;
            // 去重
            if (!dealed.contains(url)) {
                dealed.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        // 返回
        return resources;
    }

}
