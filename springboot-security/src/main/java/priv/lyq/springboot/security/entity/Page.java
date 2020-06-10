package priv.lyq.springboot.security.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: Yuqing Li
 */
@Data
public class Page {

    private Integer id;

    private String addr;

    private String icon;

    private String desc;

    private List<Button> buttons;

}