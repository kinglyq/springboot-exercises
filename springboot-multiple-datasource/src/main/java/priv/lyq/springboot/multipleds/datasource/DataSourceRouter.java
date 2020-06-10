package priv.lyq.springboot.multipleds.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 抽象类{@link AbstractRoutingDataSource}的实现，据查找键调用目标数据源
 *
 * @author Yuqing Li
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabase();
    }

}