package priv.lyq.springboot.web.controller;

import com.github.kinglyq.common.http.response.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:40:00
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @RequestMapping("login")
    public Result login(){
        return Result.success();
    }

}
