package priv.lyq.springboot.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Li Yuqing
 */
@SpringBootApplication
@MapperScan({
    "priv.lyq.springboot.datasource.mapper"
})
public class SpringbootDatasourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatasourceApplication.class, args);
    }
}
