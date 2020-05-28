package priv.lyq.springboot.multipleds.service;

import priv.lyq.springboot.multipleds.entity.User;

/**
 * @author: Yuqing Li
 */
public interface DemoService {

    int insertUser(User user);

    int insertUser(User user, String e);

}
