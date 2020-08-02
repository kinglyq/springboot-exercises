package top.funsite.springboot.datasource.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import top.funsite.springboot.datasource.datasource.properties.DataSourceProperties;
import top.funsite.springboot.datasource.datasource.properties.DatabaseProperties;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * datasource、sqlSessionFactory
 *
 * @author Li Yuqing
 * @date 2020-05-28 10:38:00
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Resource
    private DatabaseProperties config;

    @Bean("datasource")
    public DataSource datasource() {
        Map<Object, Object> targetDataSources = new HashMap<>(16);
        // AbstractRoutingDataSource的实现
        DataSourceRouter routing = new DataSourceRouter();
        // 遍历枚举类找到yml对应的配置进行自动装配
        String defaultDataSource = "";
        for (Database db : Database.values()) {
            DataSourceProperties config = this.config.getDatasource().get(db);
            if (null == config) {
                log.warn("无法找到 {} 对应的数据源配置", db);
                continue;
            }
            DataSource dataSource = dataSourceAutoConfiguring(config);
            targetDataSources.put(db, dataSource);
        }
        // 设置默认数据源
        routing.setDefaultTargetDataSource(targetDataSources.get(this.config.getDefaultDb()));
        log.info("默认数据源: {}", defaultDataSource);
        // set
        routing.setTargetDataSources(targetDataSources);
        return routing;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("datasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Lazy
    @Primary
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // MyBatis的配置从xml中获取
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(config.getMybatis().getConfigLocation()));
        // 设置mapper.xml的路径
        org.springframework.core.io.Resource[] resources = resolver.getResources(config.getMybatis().getMapperLocations());
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Lazy
    @Primary
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate popSqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 根据枚举类的找到对应的配置类对象然后再得到数据源
     *
     * @param database 数据库枚举类
     * @return {@link DataSource} 数据源
     * @see Database
     */
    private DataSource dataSourceAutoConfiguring(Database database) {
        DataSourceProperties config = this.config.getDatasource().get(database);
        return dataSourceAutoConfiguring(config);
    }

    /**
     * 根据配置对象得到数据源
     *
     * @param config 配置类对象
     * @return {@link DataSource} 数据源
     * @see DataSourceProperties
     */
    private DataSource dataSourceAutoConfiguring(DataSourceProperties config) {
        DruidDataSource dataSource = DataSourceBuilder.create().type(DruidDataSource.class).build();
        /* 基础配置 */
        dataSource.setUrl(config.getUrl());
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());
        /* 额外配置 */
        dataSource.setInitialSize(config.getInitialSize());
        dataSource.setMaxActive(config.getMaxActive());
        dataSource.setMinIdle(config.getMinIdle());
        dataSource.setPoolPreparedStatements(config.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(config.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setTestOnBorrow(config.isTestOnBorrow());
        dataSource.setTestOnReturn(config.isTestOnReturn());
        return dataSource;
    }

}
