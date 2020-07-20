package priv.lyq.springboot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.lyq.springboot.web.filter.RequestFilter;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li Yuqing
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
                .excludePathPatterns("/assets/**", "index.html");
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("").allowCredentials()
    }*/

}
