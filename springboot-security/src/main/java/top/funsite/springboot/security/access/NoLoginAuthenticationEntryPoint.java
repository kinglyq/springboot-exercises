package top.funsite.springboot.security.access;

import com.github.kinglyq.common.http.HttpStatus;
import com.github.kinglyq.common.http.response.ResponseWriter;
import com.github.kinglyq.common.http.response.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

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
        ResponseWriter.writerJson(response, Result.error(HttpStatus.UNAUTHORIZED, "未登录，禁止访问", null));
    }

}
