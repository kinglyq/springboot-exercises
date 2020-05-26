package priv.lyq.springboot.security.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import priv.lyq.springboot.security.entity.Result;
import priv.lyq.springboot.security.entity.Role;
import priv.lyq.springboot.security.entity.User;
import priv.lyq.springboot.security.enums.ResponseCode;
import priv.lyq.springboot.security.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 登录拦截器
 *
 * @author Yuqing Li
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
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("username"), request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        List<Role> authorities = user.getAuthorities();
        String[] roles = new String[authorities.size()];
        for (int i = 0; i < authorities.size(); i++) {
            roles[i] = authorities.get(i).getAuthority();
        }
        String token = JwtTokenUtil.createToken(user.getId(), Arrays.toString(roles));
        // 设置编码和请求头
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 设置token
        response.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
        response.getWriter().write(JSON.toJSONString(Result.success("登录成功")));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        ResponseCode resp;
        // 账号过期
        if (failed instanceof AccountExpiredException) {
            resp = ResponseCode.ACCOUNT_EXPIRED;
        }
        // 密码错误
        else if (failed instanceof BadCredentialsException) {
            resp = ResponseCode.WRONG_PASSWORD;
        }
        // 密码过期
        else if (failed instanceof CredentialsExpiredException) {
            resp = ResponseCode.PASSWORD_EXPIRED;
        }
        // 账号不可用
        else if (failed instanceof DisabledException) {
            resp = ResponseCode.ACCOUNT_UNAVAILABLE;
        }
        // 账号锁定
        else if (failed instanceof LockedException) {
            resp = ResponseCode.ACCOUNT_LOCKED;
        }
        // 用户不存在
        else if (failed instanceof InternalAuthenticationServiceException) {
            resp = ResponseCode.USER_NOT_FOUND;
        }
        // 其他错误
        else {
            resp = ResponseCode.UNKNOWN_MISTAKE;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // 将反馈通过HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(Result.error(resp.code, resp.desc)));
    }
}