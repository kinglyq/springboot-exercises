package priv.lyq.springboot.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Li Yuqing
 * @date 2020-05-24 08:17:00
 */
@SpringBootApplication
@MapperScan("priv.lyq.springboot.security.mapper")
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }

}
