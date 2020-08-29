package top.funsite.springboot.security.http.response;


import org.springframework.http.MediaType;
import top.funsite.springboot.security.util.JsonUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 向客户端输出文本类型数据
 *
 * @author Li Yuqing
 * @date 2020-07-21 10:01:00
 */
public class ResponseWriter {

    public static void writerJson(HttpServletResponse response, Object data) throws IOException {
        final String s = JsonUtils.writeValueAsString(data);
        write(response, s, MediaType.APPLICATION_JSON);
    }

    public static void writerHtml(HttpServletResponse response, String data) throws IOException {
        write(response, data, MediaType.TEXT_HTML);
    }

    public static void writerXml(HttpServletResponse response, String data) throws IOException {
        write(response, data, MediaType.TEXT_XML);
    }

    private static void write(HttpServletResponse response, String data, MediaType type) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(type.toString());
        out.write(data.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }
}
