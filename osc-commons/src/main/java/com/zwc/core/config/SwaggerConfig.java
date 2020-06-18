package com.zwc.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Desc TODO   swagger 配置
 * @Date 2019/4/3 10:33
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     *  应用名称
     */
    @Value("${osc.swagger.name}")
    private String name;
    /**
     *  版本号
     */
    @Value("${osc.swagger.version}")
    private String version;

    /*
     * @ClassName SwaggerConfig
     * @Desc TODO   swagger 配置信息
     * @Date 2019/4/3 11:00
     * @Version 1.0
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())     // swagger 网页描述信息
                .enable(true)   // 是否开启
                .select()       // 选择那些路径和 api 会生成 document
                .apis(RequestHandlerSelectors.basePackage("com.zwc"))   // com.zwc 包下的 api 会生成 document
                .paths(PathSelectors.any()) // 表示所有路径都符合。PathSelectors.none() 表示所有路径都不符合
                .build();
    }

    /*
     * @ClassName SwaggerConfig
     * @Desc TODO   swagger 网页描述信息
     * @Date 2019/4/3 10:40
     * @Version 1.0
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(name) // 标题
                .description("接口文档") // 描述
                .version(version)   // 版本
                .build();
    }

}
