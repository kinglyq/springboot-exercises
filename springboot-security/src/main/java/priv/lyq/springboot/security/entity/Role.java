package priv.lyq.springboot.security.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author: Yuqing Li
 */
public class Role implements GrantedAuthority {

    @Getter
    @Setter
    private Integer id;

    @Setter
    private String name;

    @Getter
    @Setter
    private String desc;

    @Override
    public String getAuthority() {
        return name;
    }
}
