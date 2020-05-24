package priv.lyq.sboot.security.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import priv.lyq.sboot.security.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuqing li
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Assert.hasLength(username, "用户名不能为空");
        System.out.println("UserDetailsServiceImpl:" + username);
        // User user =  mapper.getUser(username)
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        authorities.add(new SimpleGrantedAuthority("normal"));
        User user = new User();
        user.setUsername("user");
        // https://blog.csdn.net/canon_in_d_major/article/details/79675033
        user.setPassword("{noop}123456");
        user.setAuthorities(authorities);
        return user;
    }
}
