package priv.lyq.springboot.simpleweb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.simpleweb.entity.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuqing Li
 */
@RestController
@RequestMapping(path = "test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @RequestMapping("req-path")
    public Result path(HttpServletRequest request){
        return Result.success(request.getContextPath());
    }

}
