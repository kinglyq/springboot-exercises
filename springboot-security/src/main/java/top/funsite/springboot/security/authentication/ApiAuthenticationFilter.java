package top.funsite.springboot.security.authentication;

import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import top.funsite.springboot.security.http.response.ResponseStatus;
import top.funsite.springboot.security.http.response.ResponseWriter;
import top.funsite.springboot.security.http.response.Result;
import top.funsite.springboot.security.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 登录成功后 走此类进行鉴权操作
 *
 * @author Li Yuqing
 * @date 2020-05-24 08:50:00
 */
public class ApiAuthenticationFilter extends BasicAuthenticationFilter {

    public ApiAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER.toLowerCase());
        // 若请求头中没有Authorization或是不以Bearer 开头 则直接放行
        if (token == null || !token.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 去掉前缀 获取Token字符串
        token = token.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        Claims claims = JwtTokenUtil.checkToken(token);
        ResponseStatus status;
        // token解析错误
        if (null == claims) {
            status = ResponseStatus.TOKEN_PARSING_ERROR;
            ResponseWriter.writerJson(response, Result.error(status, null));
            return;
        }
        // token过期
        if (JwtTokenUtil.isExpired(token)) {
            status = ResponseStatus.TOKEN_EXPIRED;
            ResponseWriter.writerJson(response, Result.error(status, null));
            return;
        }
        // 从token中解密获取用户名
        String username = JwtTokenUtil.getUsername(token);
        // 从token中解密获取用户角色
        String[] roles = JwtTokenUtil.getRoles(token);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        if (null != username) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            super.doFilterInternal(request, response, chain);
        }
    }
}