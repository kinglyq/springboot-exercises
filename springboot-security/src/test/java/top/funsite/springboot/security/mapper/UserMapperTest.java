package top.funsite.springboot.security.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.funsite.springboot.security.entity.User;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void selectUserByName() {
        User user = userMapper.selectUserByName("oaa");
        System.out.println(user);
    }
}