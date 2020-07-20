package priv.lyq.springboot.datasource.datasource.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Li Yuqing
 */
@Getter
@Setter
public class MybatisProperties {

    /**
     * Mybatis配置文件(xml)位置
     */
    private String configLocation;

    /**
     * Mybatis mapper.xml位置
     */
    private String mapperLocations;

}
