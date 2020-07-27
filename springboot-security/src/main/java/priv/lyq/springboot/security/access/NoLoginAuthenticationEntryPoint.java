package priv.lyq.springboot.security.access;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import priv.lyq.springboot.common.response.ResponseResult;
import priv.lyq.springboot.common.response.ResponseStatus;
import priv.lyq.springboot.common.response.ResponseWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录访问处理
 *
 * @author Li Yuqing
 * @date 2020-05-24 16:59:00
 */
public class NoLoginAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setStatus(401);
        ResponseWriter.writerJson(response, ResponseResult.error(ResponseStatus.UNAUTHORIZED, "未登录，禁止访问", null));
    }

}
