package top.funsite.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author Li Yuqing
 * @date 2020-07-28 15:48:00
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加BufferedImage转换
     *
     * @param converters converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new BufferedImageHttpMessageConverter());
    }

}
