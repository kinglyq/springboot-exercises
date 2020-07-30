package priv.lyq.springboot.security.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Yuqing
 * @date 2020-05-24 14:11:00
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    /*@PutMapping("${id}")
    public ResponseResult updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

    }*/

}
