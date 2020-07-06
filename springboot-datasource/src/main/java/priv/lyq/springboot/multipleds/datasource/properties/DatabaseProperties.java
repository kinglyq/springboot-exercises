package priv.lyq.springboot.multipleds.datasource.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import priv.lyq.springboot.multipleds.datasource.Database;

import java.util.Map;

/**
 * DataSource与Mybatis的配置
 *
 * @author Yuqing Li
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "database-config")
public class DatabaseProperties {

    /**
     * mybatis配置
     */
    private priv.lyq.springboot.web.multipleds.properties.MybatisProperties mybatis;

    /**
     * 默认数据源
     */
    private Database defaultDb;

    /**
     * 数据源集合
     */
    private Map<Database, DataSourceProperties> datasource;

}