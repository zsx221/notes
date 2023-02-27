package SpringTest.spring.config.aop.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class interceptorConfig implements WebMvcConfigurer {
    @Resource
    HandlerInterceptorAdapter handlerInterceptorAdapter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptorAdapter).addPathPatterns("/**").addPathPatterns("/error");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
