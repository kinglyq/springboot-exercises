package top.funsite.springboot.security.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.funsite.springboot.security.entity.User;

/**
 * @author Li Yuqing
 * @date 2020-05-24 14:11:00
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    /**
     * 通过注入 Authentication 对象，进而获取到当前用户信息
     *
     * @param authentication {@link Authentication}
     * @return 用户信息
     * @see User
     */
    @GetMapping("info")
    public User getUserInfo(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

}
