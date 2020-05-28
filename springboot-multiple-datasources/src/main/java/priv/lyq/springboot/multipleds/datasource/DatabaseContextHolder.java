package priv.lyq.springboot.multipleds.datasource;

import org.springframework.util.Assert;

/**
 * @author: Yuqing Li
 */
public class DatabaseContextHolder {

    private static ThreadLocal<Database> CONTEXT = new ThreadLocal<>();

    /**
     * 切换(设置)数据源
     *
     * @param database 数据源名称
     */
    public static void setDatabase(Database database) {
        Assert.notNull(database, "Database cannot be null");
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
