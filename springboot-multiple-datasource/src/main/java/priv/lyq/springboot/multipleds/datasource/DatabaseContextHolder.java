package priv.lyq.springboot.multipleds.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * 通过线程绑定的事务上下文切换数据源
 *
 * @author Yuqing Li
 */
@Slf4j
public class DatabaseContextHolder {

    private static ThreadLocal<Database> CONTEXT = new ThreadLocal<>();

    /**
     * 切换(设置)数据源
     *
     * @param database 数据源名称
     */
    public static void setDatabase(Database database) {
        Assert.notNull(database, "Database cannot be null");
        log.info("切换到数据库：{}", database);
        CONTEXT.set(database);
    }

    public static Database getDatabase() {
        return CONTEXT.get();
    }

    /**
     * 移除当前数据源
     */
    public static void clear() {
        CONTEXT.remove();
    }

}
