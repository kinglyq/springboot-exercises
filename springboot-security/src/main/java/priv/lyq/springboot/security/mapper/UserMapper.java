package priv.lyq.springboot.security.mapper;

import org.apache.ibatis.annotations.Param;
import priv.lyq.springboot.security.entity.User;

/**
 * @author: Yuqing Li
 */
public interface UserMapper {

    User selectUserByName(@Param("username") String username);

}
