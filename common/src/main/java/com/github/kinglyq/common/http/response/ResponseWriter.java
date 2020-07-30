package com.github.kinglyq.common.http.response;

import com.github.kinglyq.common.http.MediaType;
import com.github.kinglyq.common.util.JsonUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Li Yuqing
 * @date 2020-07-21 10:01:00
 */
public class ResponseWriter {

    public static void writerJson(HttpServletResponse response, Object data) throws IOException {
        final String s = JsonUtils.writeValueAsString(data);
        write(response, s, MediaType.APPLICATION_JSON_VALUE);
    }

    public static void writerHtml(HttpServletResponse response, String data) throws IOException {
        write(response, data, MediaType.TEXT_HTML_VALUE);
    }

    public static void writerXml(HttpServletResponse response, String data) throws IOException {
        write(response, data, MediaType.TEXT_XML_VALUE);
    }

    private static void write(HttpServletResponse response, String data, MediaType type) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setContentType(type.value);
        response.getWriter().write(data);
    }

}
