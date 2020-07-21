package priv.lyq.springboot.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Li Yuqing
 * @date 2020-05-28 08:42:00
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
