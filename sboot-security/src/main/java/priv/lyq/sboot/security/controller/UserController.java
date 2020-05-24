package priv.lyq.sboot.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuqing li
 */
@RestController
public class UserController {

    @GetMapping("data")
    public Map<String, Object> data(){
        Map<String ,Object> map = new HashMap<>(16);
        map.put("msg", "zzZ");
        return map;
    }

}
