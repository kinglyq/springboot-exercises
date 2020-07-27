package priv.lyq.springboot.security.access;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import priv.lyq.springboot.common.response.ResponseResult;
import priv.lyq.springboot.common.response.ResponseStatus;
import priv.lyq.springboot.common.response.ResponseWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 已登录，无访问权限
 *
 * @author Li Yuqing
 * @date 2020-06-27 14:45:00
 */
public class NoPermissionDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ResponseWriter.writerJson(response, ResponseResult.error(ResponseStatus.FORBIDDEN));
    }
}

