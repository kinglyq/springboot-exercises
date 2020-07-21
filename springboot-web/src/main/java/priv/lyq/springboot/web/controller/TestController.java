package priv.lyq.springboot.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.common.response.ResponseResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:29:00
 */
@RestController
@RequestMapping(path = "test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @RequestMapping("req-path")
    public ResponseResult path(HttpServletRequest request){
        return ResponseResult.success(request.getContextPath());
    }

}
