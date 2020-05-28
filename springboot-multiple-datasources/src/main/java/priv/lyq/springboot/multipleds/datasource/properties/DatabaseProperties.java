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
 * @author: Yuqing Li
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "database-config")
public class DatabaseProperties {

    /**
     * 数据源集合
     */
    private Map<Database, DataSourceProperties> datasource;

    /**
     * mybatis配置
     */
    private MybatisProperties mybatis;

}