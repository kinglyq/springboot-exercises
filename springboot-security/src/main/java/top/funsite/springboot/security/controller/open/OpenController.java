package top.funsite.springboot.security.controller.open;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;

/**
 * @author Li Yuqing
 * @date 2020-07-21 10:01:00
 */
@Slf4j
@RestController
@RequestMapping(path = "open")
public class OpenController {

    @Resource(name = "kaptcha")
    private DefaultKaptcha kaptcha;

    @GetMapping(path = "code", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage o1() {
        String text = kaptcha.createText();
        log.info("验证码：{}", text);
        return kaptcha.createImage(text);
    }

}
