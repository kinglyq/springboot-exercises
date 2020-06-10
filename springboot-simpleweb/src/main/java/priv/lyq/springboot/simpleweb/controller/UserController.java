package priv.lyq.springboot.simpleweb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.simpleweb.entity.Result;

/**
 * @author Yuqing Li
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @RequestMapping("login")
    public Result login(){
        return Result.success();
    }

}