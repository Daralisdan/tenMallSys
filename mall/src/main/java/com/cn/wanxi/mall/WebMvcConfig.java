package com.cn.wanxi.mall;


import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 过滤器
 * @author hqc
 * @Date 2019年3月20日
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * -设置url后缀模式匹配规则
     * -该设置匹配所有的后缀，使用.do或.action都可以
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)	//设置是否是后缀模式匹配,即:/test.*
                .setUseTrailingSlashMatch(false);	//设置是否自动后缀路径模式匹配,即：/test/
    }

    /**
     * -该设置严格指定匹配后缀*.do或.action，但有风险
     * @param dispatcherServlet servlet调度器
     * @return ServletRegistrationBean
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet //dispatcherServlet) {
//    	ServletRegistrationBean servletServletRegistrationBean = new //ServletRegistrationBean(dispatcherServlet);
//        servletServletRegistrationBean.addUrlMappings("*.do");//指定.do后缀，可替换其他后缀
//        return servletServletRegistrationBean;
//    }


    /**
     * create by yaodan
     * <p>
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     */
    //@Override
    /*
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false).setUseTrailingSlashMatch(true);
    }
*/
    /**
     * create by yaodan
     * <p>
     * [映射swagger2 静态资源文件]
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");


        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        //图片映射
        registry.addResourceHandler("upload/**")
                .addResourceLocations(ResourceUtils.FILE_URL_PREFIX + "D://images/upload/");
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");

    }


    /**
     * create by yaodan
     * <p>
     * 跨域问题
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 是否允许证书 不再默认开启
                .allowCredentials(true)
                // 设置允许的方法
                .allowedMethods("*")
                // 跨域允许时间
                .maxAge(3600);
    }



}
