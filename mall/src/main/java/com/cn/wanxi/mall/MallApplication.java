package com.cn.wanxi.mall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletResponse;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.cn.wanxi"})
public class MallApplication extends WebMvcConfigurationSupport {


    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
        System.out.println("Springboot项目启动入口");
    }

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        // 常用的两种
        // 匹配结尾 / :会识别 url 的最后一个字符是否为 /
        // localhost:8080/test 与 localhost:8080/test/ 等价
        configurer.setUseTrailingSlashMatch(false);
        // 匹配后缀名：会识别 xx.* 后缀的内容
        // localhost:8080/test 与 localhost:8080/test.jsp 等价
        configurer.setUseSuffixPatternMatch(true);

        // TODO PathMatchConfigurer 还提供其他的一些 api 以供使用
    }
}
