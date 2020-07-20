package priv.lyq.springboot.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import priv.lyq.springboot.common.response.ResponseResult;
import priv.lyq.springboot.common.response.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Li Yuqing
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        /*response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        response.getWriter().print("您未登录，没有访问权限");*/
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ObjectMapper om = new ObjectMapper();
        response.getWriter().write(om.writeValueAsString(ResponseResult.error(ResponseStatus.UNAUTHORIZED)));
    }

}
