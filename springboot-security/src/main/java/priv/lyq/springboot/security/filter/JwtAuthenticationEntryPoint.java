package priv.lyq.springboot.security.filter;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import priv.lyq.springboot.security.entity.Result;
import priv.lyq.springboot.security.enums.ResponseCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Yuqing Li
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        /*response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().print("您未登录，没有访问权限");*/
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JSON.toJSONString(Result.error(ResponseCode.USER_IS_NOT_LOGGED_IN.code, "您未登录，没有访问权限")));
    }

}
