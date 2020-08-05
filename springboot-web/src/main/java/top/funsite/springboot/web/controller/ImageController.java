package top.funsite.springboot.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.funsite.springboot.web.entity.VerifyCode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Li Yuqing
 * @date 2020-05-26 11:21:00
 */
@Slf4j
@RestController
@RequestMapping("image")
@Api(value = "图片", description = "图片")
public class ImageController {

    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "captcha", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage verifyCode() {
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setLine(true);
        return verifyCode.getImage();
    }

    @ApiOperation(value = "获取图片")
    @GetMapping(value = "io", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage image() {
        try (InputStream inputStream = new FileInputStream("xxx.png")) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
