package priv.lyq.springboot.common.response;

import priv.lyq.springboot.common.util.JsonUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Li Yuqing
 * @date 2020-07-21 10:01:00
 */
public class ResponseWriter {

    protected static final String APPLICATION_JSON_VALUE = "application/json";

    protected static final String TEXT_HTML_VALUE = "text/html";

    public static void writerJson(HttpServletResponse response, Object data) throws IOException {
        final String s = JsonUtils.writeValueAsString(data);
        write(response, s, APPLICATION_JSON_VALUE);
    }

    public static void writerHtml(HttpServletResponse response, String data) throws IOException {
        write(response, data, TEXT_HTML_VALUE);
    }

    private static void write(HttpServletResponse response, String data, String type) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(type);
        response.getWriter().write(data);
    }

}
