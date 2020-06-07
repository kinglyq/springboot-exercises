package priv.lyq.springboot.simpleweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: Yuqing Li
 */
@Slf4j
@RestController
@RequestMapping("image")
public class ImageController {

    @RequestMapping(value = "io", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage image() {
        try (InputStream inputStream = new FileInputStream("C:\\Users\\b19081210\\Pictures\\line-height.png")) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
