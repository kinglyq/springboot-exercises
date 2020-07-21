package priv.lyq.springboot.datasource.datasource.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import priv.lyq.springboot.datasource.datasource.Database;

import java.util.Map;

/**
 * DataSource与Mybatis的配置
 *
 * @author Li Yuqing
 * @date 2020-05-28 10:11:00
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "database-config")
public class DatabaseProperties {

    /**
     * mybatis配置
     */
    private MybatisProperties mybatis;

    /**
     * 默认数据源
     */
    private Database defaultDb;

    /**
     * 数据源集合
     */
    private Map<Database, DataSourceProperties> datasource;

}