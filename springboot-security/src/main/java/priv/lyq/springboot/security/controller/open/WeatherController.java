package priv.lyq.springboot.security.controller.open;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.common.response.ResponseResult;

/**
 * @author Li Yuqing
 * @date 2020-07-21 10:01:00
 */
@RestController
@RequestMapping(path = "open", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherController {

    @GetMapping("o1")
    public ResponseResult o1(){
        return ResponseResult.success();
    }

}
