package top.funsite.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置
 *
 * @author Li Yuqing
 * @date 2020-08-04 08:05:38
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("top.funsite.springboot.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("Spring Web接口文档")
                        .description("ENTIRETY REST")
                        .version("1.0")
                        .contact(new Contact("kinglyq", "https://www.funsite.top",
                                "kinglyq@funsite.top"))
                        .build());
    }

}