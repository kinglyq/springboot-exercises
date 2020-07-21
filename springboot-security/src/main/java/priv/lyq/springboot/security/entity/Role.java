package priv.lyq.springboot.security.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

/**
 * 角色
 *
 * @author Yuqing Li
 * @date 2020-05-24 10:24:00
 */
@Getter
@Setter
@ToString
public class Role implements GrantedAuthority {

    private Integer id;

    private String roleName;

    private String roleDesc;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
