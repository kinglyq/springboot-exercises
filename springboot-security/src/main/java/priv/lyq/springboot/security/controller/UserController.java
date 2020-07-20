package priv.lyq.springboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.common.response.ResponseResult;

import java.util.Map;

/**
 * @author Li Yuqing
 */
@RestController
public class UserController {

    @GetMapping("data")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseResult data(){
        return ResponseResult.success("can");
    }

    @PostMapping("data2")
    public ResponseResult data2(@RequestBody Map<String, String> map){
        return ResponseResult.success("can");
    }

}
