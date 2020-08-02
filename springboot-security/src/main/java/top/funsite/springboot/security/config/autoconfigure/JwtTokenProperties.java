package top.funsite.springboot.security.config.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;


/**
 * token配置属性
 *
 * @author Li Yuqing
 * @date 2020-07-27 11:34:16
 */
@Validated
@Configuration
@ConfigurationProperties(prefix = "jwt.token")
public class JwtTokenProperties {

    /**
     * 签名主题
     */
    public static String subject;

    /**
     * 有效期（不写单位，默认按照毫秒处理）可用单位：
     * <ul><li>ns 纳秒</li><li>us 微秒</li><li>ms 毫秒</li><li>s 秒</li><li>m 分</li><li>h 时</li><li>d 天</li></ul>
     */
    public static Duration expiration;

    /**
     * 密钥
     */
    public static String appSecretKey;

    public void setSubject(String subject) {
        JwtTokenProperties.subject = subject;
    }

    public void setExpiration(Duration expiration) {
        JwtTokenProperties.expiration = expiration;
    }

    public void setAppSecretKey(String appSecretKey) {
        JwtTokenProperties.appSecretKey = appSecretKey;
    }
}
