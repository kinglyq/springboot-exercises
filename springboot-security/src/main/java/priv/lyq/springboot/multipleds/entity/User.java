package priv.lyq.springboot.multipleds.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author Yuqing Li
 */
public class User implements UserDetails {

    @Getter
    @Setter
    private String id;

    @Setter
    private String username;

    @Setter
    private String password;

    @Setter
    private List<Role> authorities;

    @Getter
    @Setter
    private List<Page> pages;

    @Override
    public List<Role> getAuthorities() {
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

}
