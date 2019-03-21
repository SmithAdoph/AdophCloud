package com.adoph.permission.config;

import com.adoph.permission.interceptor.IndexInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Web相关配置适配器
 *
 * @author Adoph
 * @version v1.0
 * @date 2017/11/22
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 访问路径白名单列表
     */
    private static final String[] EXCLUDE_PATH_PATTERNS = {
            "/index.do",
            "/login/**",
            "/error",
            "/swagger-ui.html"
    };


    /**
     * 静态资源路径配置
     *
     * @param registry 资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**").addResourceLocations("classpath:/templates/app/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 默认访问视图
     *
     * @param registry 视图
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.do");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 过滤器拦截规则
     *
     * @param registry 过滤器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS);
    }
}
