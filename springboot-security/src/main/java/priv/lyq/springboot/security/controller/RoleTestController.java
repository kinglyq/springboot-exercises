package priv.lyq.springboot.security.controller;

import com.github.kinglyq.common.http.response.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限测试接口
 *
 * @author Li Yuqing
 * @date 2020-07-28 15:24:23
 */
@RestController
@RequestMapping(path = "test")
public class RoleTestController {

    @GetMapping("admin")
    @PreAuthorize("hasAuthority('admin')")
    public Result admin(){
        return Result.success("admin");
    }

    @GetMapping("normal")
    @PreAuthorize("hasAuthority('normal')")
    public Result normal(){
        return Result.success("normal");
    }

}
