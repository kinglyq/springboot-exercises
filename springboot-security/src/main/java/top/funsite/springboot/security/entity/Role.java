package top.funsite.springboot.security.entity;

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
@ToString
public class Role implements GrantedAuthority {

    @Getter
    @Setter
    private Integer id;

    @Setter
    private String roleName;

    @Getter
    @Setter
    private String roleDesc;

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public int hashCode() {
        return this.roleName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Role) {
            return roleName.equals(((Role) obj).roleName);
        }
        return false;
    }
}
