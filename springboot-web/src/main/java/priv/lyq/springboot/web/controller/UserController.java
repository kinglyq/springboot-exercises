package priv.lyq.springboot.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.common.response.ResponseResult;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:40:00
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @RequestMapping("login")
    public ResponseResult login(){
        return ResponseResult.success();
    }

}
