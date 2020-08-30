package top.funsite.springboot.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 用户信息
 *
 * @author Yuqing Li
 * @date 2020-05-24 10:24:00
 */
@ToString
@JsonIgnoreProperties(value = {"password", "authorities"})
public class User /*implements UserDetails*/ {

    @Getter
    @Setter
    private String id;

    @Setter
    private String username;

    @Setter
    private String password;

    @Setter
    private List<Role> authorities;

    //@Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    //@Override
    public String getPassword() {
        return password;
    }

    //@Override
    public String getUsername() {
        return username;
    }

    //@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //@Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //@Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //@Override
    public boolean isEnabled() {
        return true;
    }
}
