package priv.lyq.sboot.security.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import priv.lyq.sboot.security.entity.User;
import priv.lyq.sboot.security.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuqing li
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info(request.getParameter("username"));
        log.info(request.getParameter("password"));
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username"),request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        /*User user = (User) authResult.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();*/
        String token = JwtTokenUtil.createToken("user", authResult.getAuthorities().toString());
        // 设置编码和请求头
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 设置token
        response.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("msg", "登录成功");
        response.getWriter().write(JSON.toJSONString(map));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String returnData = "";
        // 账号过期
        if (failed instanceof AccountExpiredException) {
            returnData = "账号过期";
        }
        // 密码错误
        else if (failed instanceof BadCredentialsException) {
            returnData = "密码错误";
        }
        // 密码过期
        else if (failed instanceof CredentialsExpiredException) {
            returnData = "密码过期";
        }
        // 账号不可用
        else if (failed instanceof DisabledException) {
            returnData = "账号不可用";
        }
        // 账号锁定
        else if (failed instanceof LockedException) {
            returnData = "账号锁定";
        }
        // 用户不存在
        else if (failed instanceof InternalAuthenticationServiceException) {
            returnData = "用户不存在";
        }
        // 其他错误
        else {
            returnData = "未知异常";
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 将反馈塞到HttpServletResponse中返回给前台
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", 1);
        map.put("msg", returnData);
        response.getWriter().write(JSON.toJSONString(map));
    }
}