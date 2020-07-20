package priv.lyq.springboot.datasource.util;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * 信息编码转换
 *
 * @author Li Yuqing
 */
public class InformationCodingUtils {

    /**
     * Base64编码
     *
     * @param str 待编码字符串
     * @return 编码字符串
     */
    public static String bToa(String str) {
        return new BASE64Encoder().encode(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Base64编码
     *
     * @param bytes byte[]
     * @return 编码字符串
     */
    public static String bToa(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * Base64解码
     *
     * @param str 待解码字符串
     * @return UTF_8字符串
     */
    public static String aTob(String str) {
        return aTob(str, StandardCharsets.UTF_8);
    }

    /**
     * Base64解码
     *
     * @param str     待解码字符串
     * @param charset 编码字符集
     * @return 返回指定编码字符集字符串
     */
    public static String aTob(String str, Charset charset) {
        try {
            return new String(new BASE64Decoder().decodeBuffer(str), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Unicode编码
     *
     * @param str 待编码字符串
     * @return 编码字符串
     */
    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Unicode解码
     *
     * @param str 待解码字符串
     * @return 解码字符串
     */
    public static String urlDecoder(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成32位UUID
     *
     * @return 32位UUID
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成MD5
     *
     * @param bytes byte[]
     * @return MD5
     */
    public static String md5(byte[] bytes) {
        return DigestUtils.md5DigestAsHex(bytes);
    }

    /**
     * 生成MD5
     *
     * @param inputStream InputStream
     * @return MD5
     */
    public static String md5(InputStream inputStream) {
        try {
            return DigestUtils.md5DigestAsHex(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
