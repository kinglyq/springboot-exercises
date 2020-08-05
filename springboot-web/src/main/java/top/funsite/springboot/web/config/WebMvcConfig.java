package top.funsite.springboot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.funsite.springboot.web.filter.RequestFilter;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li Yuqing
 * @date 2020-05-26 13:48:00
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    private RequestFilter requestFilter;

    /**
     * 添加BufferedImage转换
     *
     * @param converters converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new BufferedImageHttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/web/assets/**", "/web/index.html");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }


    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true);
    }*/

}
