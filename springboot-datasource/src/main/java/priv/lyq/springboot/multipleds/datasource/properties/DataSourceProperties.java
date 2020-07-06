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
     * 连接数据库的url，不同数据库不一样
     */
    private String url;

    /**
     * 这一项可配可不配，如果不配置druid会根据url自动识别dbType，然后选择相应的driverClassName
     */
    private String driverClassName;

    /**
     * 连接数据库的用户名
     */
    private String username;

    /**
     * 数据库登录密码
     */
    private String password;

    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时
     */
    private int initialSize = 0;

    /**
     * 最大连接池数量
     */
    private int maxActive = 8;

    /**
     * 最小连接池数量
     */
    private int minIdle = 0;

    /**
     * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，
     * 并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁
     */
    private long maxWait = -1;

    /**
     * 是否缓存preparedStatement，也就是PSCache。
     * PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭
     */
    private boolean poolPreparedStatements = false;

    /**
     * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
     */
    private int maxPoolPreparedStatementPerConnectionSize = 10;

    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    private boolean testOnBorrow = false;

    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    private boolean testOnReturn = false;
}