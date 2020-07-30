package priv.lyq.springboot.security.authentication;

import com.github.kinglyq.common.http.HttpStatus;
import com.github.kinglyq.common.http.response.ResponseWriter;
import com.github.kinglyq.common.http.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import priv.lyq.springboot.security.entity.Role;
import priv.lyq.springboot.security.entity.User;
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
        // 设置token
        response.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
        // 返回json
        ResponseWriter.writerJson(response, Result.success());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        HttpStatus resp;
        // 账号过期
        if (failed instanceof AccountExpiredException) {
            resp = HttpStatus.ACCOUNT_EXPIRED;
        }
        // 密码错误
        else if (failed instanceof BadCredentialsException) {
            resp = HttpStatus.WRONG_PASSWORD;
        }
        // 密码过期
        else if (failed instanceof CredentialsExpiredException) {
            resp = HttpStatus.PASSWORD_EXPIRED;
        }
        // 账号不可用
        else if (failed instanceof DisabledException) {
            resp = HttpStatus.ACCOUNT_UNAVAILABLE;
        }
        // 账号锁定
        else if (failed instanceof LockedException) {
            resp = HttpStatus.ACCOUNT_LOCKED;
        }
        // 用户不存在
        else if (failed instanceof InternalAuthenticationServiceException) {
            resp = HttpStatus.USER_NOT_FOUND;
        }
        // 其他错误
        else {
            resp = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        // 将反馈通过HttpServletResponse中返回给前台
        ResponseWriter.writerJson(response, Result.error(resp));
    }
}