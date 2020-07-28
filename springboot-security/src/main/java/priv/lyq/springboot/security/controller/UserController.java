package priv.lyq.springboot.security.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import priv.lyq.springboot.common.response.ResponseResult;

import java.util.Map;

/**
 * @author Li Yuqing
 * @date 2020-05-24 14:11:00
 */
@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("data")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseResult data() {
        return ResponseResult.success("can");
    }

    @PostMapping("data2")
    public ResponseResult data2(@RequestBody Map<String, String> map) {
        return ResponseResult.success("can");
    }

    /*@PutMapping("${id}")
    public ResponseResult updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

    }*/

}
