package top.funsite.springboot.security.access;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import top.funsite.springboot.security.http.response.ResponseStatus;
import top.funsite.springboot.security.http.response.ResponseWriter;
import top.funsite.springboot.security.http.response.Result;

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
        ResponseWriter.writerJson(response, Result.error(ResponseStatus.UNAUTHORIZED, null));
    }

}
