package top.funsite.springboot.security.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.funsite.springboot.security.entity.Role;
import top.funsite.springboot.security.entity.User;
import top.funsite.springboot.security.http.response.ResponseStatus;
import top.funsite.springboot.security.http.response.ResponseWriter;
import top.funsite.springboot.security.http.response.Result;
import top.funsite.springboot.security.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 登录拦截器
 *
 * @author Li Yuqing
 * @date 2020-05-24 08:33:00
 */
@Slf4j
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public LoginAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter(
                "username"), request.getParameter("password")));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        List<Role> authorities = user.getAuthorities();
        String[] roles = new String[authorities.size()];
        for (int i = 0; i < authorities.size(); i++) {
            roles[i] = authorities.get(i).getAuthority();
        }
        String token = JwtTokenUtil.createToken(user.getId(), Arrays.toString(roles));
        // 设置token
        response.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
        // 返回json
        ResponseWriter.writerJson(response, Result.success());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        ResponseStatus status;
        // 账号过期
        if (failed instanceof AccountExpiredException) {
            status = ResponseStatus.ACCOUNT_EXPIRED;
        }
        // 密码错误
        else if (failed instanceof BadCredentialsException) {
            status = ResponseStatus.WRONG_PASSWORD;
        }
        // 密码过期
        else if (failed instanceof CredentialsExpiredException) {
            status = ResponseStatus.PASSWORD_EXPIRED;
        }
        // 账号不可用
        else if (failed instanceof DisabledException) {
            status = ResponseStatus.ACCOUNT_UNAVAILABLE;
        }
        // 账号锁定
        else if (failed instanceof LockedException) {
            status = ResponseStatus.ACCOUNT_LOCKED;
        }
        // 用户不存在
        else if (failed instanceof InternalAuthenticationServiceException) {
            status = ResponseStatus.USER_NOT_FOUND;
        }
        // 其他错误
        else {
            status = ResponseStatus.INTERNAL_SERVER_ERROR;
        }
        // 将反馈通过HttpServletResponse中返回给前台
        ResponseWriter.writerJson(response, Result.error(status, null));
    }
}