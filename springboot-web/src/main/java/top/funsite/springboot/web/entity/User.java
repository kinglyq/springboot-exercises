package top.funsite.springboot.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 用户信息实体类
 *
 * @author Li Yuqing
 * @date 2020-08-04 08:30:23
 */
@Getter
@Setter
@ToString
@ApiModel("用户信息实体")
public class User {

    /**
     * 用户唯一ID
     */
    @ApiModelProperty(value = "用户唯一ID")
    private String id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String nickname;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private Boolean gender;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    @Length(min = 11, max = 11, message = "长度11位")
    private String tel;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerTime;
}
