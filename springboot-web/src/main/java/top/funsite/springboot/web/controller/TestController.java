package top.funsite.springboot.web.controller;

import com.github.kinglyq.common.http.response.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:29:00
 */
@RestController
@RequestMapping(path = "test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @RequestMapping("req-path")
    public Result path(HttpServletRequest request){
        return Result.success(request.getContextPath());
    }

}
