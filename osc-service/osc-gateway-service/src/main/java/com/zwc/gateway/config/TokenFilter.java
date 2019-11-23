package com.zwc.gateway.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName TokenFilter
 * @Desc TODO   请求认证过滤器
 * @Date 2019/6/29 17:49
 * @Version 1.0
 */
public class TokenFilter implements GlobalFilter{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 响应对象
        ServerHttpResponse response = exchange.getResponse();

        /*// 登录注册不拦截
        if(request.getURI().toString().indexOf("login") != -1 || request.getURI().toString().indexOf("register") != -1){
            System.out.println("filter -> return");
            // 直接跳出
            return chain.filter(exchange);
        }

        // 请求是否能通过
        boolean flag = true;

        // 从请求头中获取 token ，如果没有，就重新登录
        if(!request.getHeaders().containsKey("osc-token")){
            // 请求不能通过
            flag = false;
        }

        // 请求不能通过，返回 401
        if(!flag){
            // 响应消息内容对象
            JSONObject message = new JSONObject();
            // 响应状态
            message.put("code", -1);
            // 响应内容
            message.put("msg", "缺少凭证");
            // 转换响应消息内容对象为字节
            byte[] bits = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bits);
            // 设置响应对象状态码 401
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            // 设置响应对象内容并且指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            // 返回响应对象
            return response.writeWith(Mono.just(buffer));
        }*/

        // 获取请求地址
        String beforePath = request.getPath().pathWithinApplication().value();
        // 获取响应状态码
        HttpStatus beforeStatusCode = response.getStatusCode();
        System.out.println("响应码：" + beforeStatusCode + "，请求路径：" + beforePath);
        // 请求前
        System.out.println("filter -> before");
        // 如果不为空，就通过
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // 获取请求地址
            String afterPath = request.getPath().pathWithinApplication().value();
            // 获取响应状态码
            HttpStatus afterStatusCode = response.getStatusCode();
            System.out.println("响应码：" + afterStatusCode + "，请求路径：" + afterPath);
            // 响应后
            System.out.println("filter -> after");
        }));
    }

}
