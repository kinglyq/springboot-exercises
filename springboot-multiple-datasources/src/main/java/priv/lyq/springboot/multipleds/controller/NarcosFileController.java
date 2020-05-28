package priv.lyq.springboot.multipleds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yuqing Li
 */
@Slf4j
@Controller
public class NarcosFileController {

    @ResponseBody
    @GetMapping("search")
    public Map<String, Object> search(@RequestParam("name") String name) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<>(16);
        String fileName = URLDecoder.decode(name, "UTF-8");
        log.info(fileName);
        map.put("name", fileName);
        return map;
    }

}
