package top.funsite.springboot.datasource.datasource.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Li Yuqing
 * @date 2020-05-28 10:22:00
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
