package priv.lyq.springboot.multipleds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yuqing Li
 */
@SpringBootApplication
@MapperScan("priv.lyq.springboot.multipleds.mapper")
public class SpringbootMultipleDsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMultipleDsApplication.class, args);
    }
}
