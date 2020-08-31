package top.funsite.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author B19081210
 * @date 2020-08-31 10:58:22
 */
@Controller
public class PageController {

    @GetMapping(value = {"", "index", "main"})
    public String index() {
        return "/pages/index.html";
    }

    @GetMapping("page/hello")
    public String hello() {
        return "/pages/hello.html";
    }

}
