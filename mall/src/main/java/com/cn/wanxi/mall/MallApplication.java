package com.cn.wanxi.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yd
 */
@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {"com.cn.wanxi"})
public class MallApplication{
    public static void main(String[] args) {

        SpringApplication.run(MallApplication.class, args);
        System.out.println("Springboot项目启动入口");
        System.out.println("master");
    }
}
