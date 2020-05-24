package priv.lyq.sboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Yuqing Li
 */
@SpringBootApplication
public class SbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootSecurityApplication.class, args);
    }

}
