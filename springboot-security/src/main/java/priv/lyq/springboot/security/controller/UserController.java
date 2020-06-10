package priv.lyq.springboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.simpleweb.entity.Result;

import java.util.Map;

/**
 * @author Yuqing Li
 */
@RestController
public class UserController {

    @GetMapping("data")
    @PreAuthorize("hasAuthority('admin')")
    public Result data(){
        return Result.success("can");
    }

    @PostMapping("data2")
    public Result data2(@RequestBody Map<String, String> map){
        System.out.println(map);
        return Result.success("can");
    }

}
