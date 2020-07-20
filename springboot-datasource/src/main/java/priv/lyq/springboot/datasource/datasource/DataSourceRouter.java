package priv.lyq.springboot.datasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 抽象类{@link AbstractRoutingDataSource}的实现，据查找键调用目标数据源
 *
 * @author Li Yuqing
 */
public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabase();
    }

}
