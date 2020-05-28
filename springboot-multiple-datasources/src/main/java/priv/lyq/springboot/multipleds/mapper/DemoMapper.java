package priv.lyq.springboot.multipleds.mapper;

import org.apache.ibatis.annotations.Param;
import priv.lyq.springboot.multipleds.entity.User;

/**
 * @author: Yuqing Li
 */
public interface DemoMapper {

    User getUserById(@Param("id") Long id);

    int insertUser(User user);

}
