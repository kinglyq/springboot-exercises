package priv.lyq.springboot.web.multipleds.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yuqing Li
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
