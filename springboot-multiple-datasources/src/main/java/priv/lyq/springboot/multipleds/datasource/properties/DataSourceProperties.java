package priv.lyq.springboot.multipleds.datasource.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * DataSource详细属性配置
 *
 * @author Yuqing Li
 */
@Getter
@Setter
public class DataSourceProperties {

    /**
     * 数据库 JDBC URL
     */
    private String url;

    /**
     * 驱动类全名
     */
    private String driverClassName;

    /**
     * 数据库登录名
     */
    private String username;

    /**
     * 数据库登录密码
     */
    private String password;

    /**
     * 是否作为默认数据源
     */
    private Boolean defaultDb = Boolean.FALSE;
}