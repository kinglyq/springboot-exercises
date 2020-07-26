package priv.lyq.springboot.common.util;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * Web下载工具类
 *
 * @author Li Yuqing
 * @date 2020-07-25 10:05:31
 */
public class DownloadUtils {

    /**
     * 设置下载http响应头信息
     *
     * @param response HttpServletResponse
     * @param fileName 文件名
     * @param length   文件大小
     */
    public static void setDownloadHeader(HttpServletResponse response, String fileName, long length) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentLengthLong(length);
        fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
    }

}
