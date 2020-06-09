package priv.lyq.springboot.multipleds.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyq.springboot.multipleds.entity.VerifyCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yuqing Li
 */
@Slf4j
@RestController
@RequestMapping("image")
public class ImageController {

    @RequestMapping(value = "verifyCode", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage verifyCode() {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setLine(false);
        return verifyCode.getImage();
    }

    @RequestMapping(value = "io", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage image() {
        try (InputStream inputStream = new FileInputStream("xxx.png")) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
