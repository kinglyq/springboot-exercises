package priv.lyq.springboot.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import priv.lyq.springboot.security.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author Li Yuqing
 * @date 2020-05-24 11:17:22
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.hasLength(username, "用户名不能为空");
        return userMapper.selectUserByName(username);
    }
}
