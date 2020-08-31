package top.funsite.springboot.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * 用户信息
 *
 * @author Yuqing Li
 * @date 2020-05-24 10:24:00
 */
@ToString
@JsonIgnoreProperties(value = {"password", "authorities"})
public class User implements UserDetails {

    private static final char TRUE = 'Y';

    @Getter
    @Setter
    private String id;

    @Setter
    private String username;

    @Setter
    private String password;

    @Setter
    private char accountNonExpired;

    @Setter
    private char accountNonLocked;

    @Setter
    private char enabled;

    @Setter
    private Set<Role> authorities;

    @Override
    public Set<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            return username.equals(((User) obj).username);
        }
        return false;
    }
}
