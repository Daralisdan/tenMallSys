//package com.cn.wanxi.mall;
//
//
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.DispatcherServlet;
//import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * 过滤器
// * @author hqc
// * @Date 2019年3月20日
// *
// */
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//    /**
//     * -设置url后缀模式匹配规则
//     * -该设置匹配所有的后缀，使用.do或.action都可以
//     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.setUseSuffixPatternMatch(false)	//设置是否是后缀模式匹配,即:/test.*
//                .setUseTrailingSlashMatch(false);	//设置是否自动后缀路径模式匹配,即：/test/
//    }
//
//    /**
//     * -该设置严格指定匹配后缀*.do或.action，但有风险
//     * @param dispatcherServlet servlet调度器
//     * @return ServletRegistrationBean
//     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
//    	ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
//        servletServletRegistrationBean.addUrlMappings("*.do");//指定.do后缀，可替换其他后缀
//
//        return servletServletRegistrationBean;
//    }
//
//}
