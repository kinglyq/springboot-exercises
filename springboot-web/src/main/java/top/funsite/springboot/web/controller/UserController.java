package top.funsite.springboot.web.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.funsite.springboot.web.entity.User;

import java.time.LocalDateTime;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:40:00
 */
@Slf4j
@RestController
@Api(value = "用户", description = "用户")
@RequestMapping(path = "api/v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping(path = "{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") @ApiParam(value = "用户名") String username) {
        User user = new User();
        user.setUsername(username);
        user.setGender(null);
        user.setNickname("根据用户名获取用户信息");
        user.setBirthday(LocalDateTime.now());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiOperation("根据用户名修改用户信息")
    @PatchMapping(path = "{username}")
    public ResponseEntity<String> updateUser(@PathVariable("username") @ApiParam(value = "用户名") String username
            , @RequestBody @Validated User user) {
        log.info(user.getNickname());
        return new ResponseEntity<>("根据用户名修改用户信息", HttpStatus.OK);
    }

    @ApiOperation("添加用户")
    @PostMapping(path = "{username}")
    public User addUser(@PathVariable("username") @ApiParam(value = "用户名") String username) {
        User user = new User();
        user.setUsername("xxx");
        user.setGender(null);
        user.setNickname("添加用户");
        user.setBirthday(LocalDateTime.now());
        return user;
    }

    @ApiOperation("根据用户名删除用户")
    @DeleteMapping(path = "{username}")
    public ResponseEntity<User> deleteUser(@PathVariable("username") @ApiParam(value = "用户名") String username) {
        User user = new User();
        user.setUsername(username);
        user.setGender(null);
        user.setNickname("根据用户名删除用户");
        user.setBirthday(LocalDateTime.now());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
