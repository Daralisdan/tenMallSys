package com.cn.wanxi.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 【配置Swagger核心类】
 * 2019/11/17,Create by yaodan
 */
@Configuration //加载Swagger配置
//@EnableSwagger2 //开启Swagger
public class Swagger2 {
    /**
     * createRestApi()使用该方法初始化api的信息
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        //创建api基本信息
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select() //控制要测试的接口
                .apis(RequestHandlerSelectors.basePackage("com.cn.wanxi.mall.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(testApiInfo());
        return docket;
    }

    /**
     * api文档初始化
     *
     * @return
     */
    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("SpringBoot利用Swagger构建API文档")
                .description("使用RestFul风格, 创建人：yaodan")
                .version("1.0")
                .build();
        return apiInfo;

    }
}
