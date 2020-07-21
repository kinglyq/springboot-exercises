package priv.lyq.springboot.security.mapper;

import org.apache.ibatis.annotations.Param;
import priv.lyq.springboot.security.entity.User;

/**
 * @author Li Yuqing
 * @date 2020-05-24 10:55:00
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     * @see User
     */
    User selectUserByName(@Param("username") String username);

}
