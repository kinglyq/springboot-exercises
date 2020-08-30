package top.funsite.springboot.security.authentication;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws
            IOException, ServletException {
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER.toLowerCase());
        // 若请求头中没有Authorization或是不以Bearer 开头 则直接放行
        if (token == null || !token.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 去掉前缀 获取Token字符串
        token = token.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        Claims claims = null;
        try {
            claims = JwtTokenUtil.getJwtBody(token);
        } catch (Exception e) {
            String cause;
            // JWT过期
            if (e instanceof ExpiredJwtException) {
                cause = "token过期";
            }
            // JWT格式/配置与应用程序期望的格式不匹配
            else if (e instanceof UnsupportedJwtException) {
                cause = "与应用程序期望的格式不匹配";
            }
            // 未正确构造JWT
            else if (e instanceof MalformedJwtException) {
                cause = "未正确构造token";
            }
            // JWT的签名或验证JWT的现有签名失败
            else if (e instanceof SignatureException) {
                cause = "签名失败";
            }
            // 其它异常
            else {
                cause = e.getMessage();
            }
            ResponseWriter.writerJson(response, Result.error(ResponseStatus.TOKEN_EXPIRED, cause));
            return;
        }
        // 从token中解密获取用户名
        String username = JwtTokenUtil.getUsername(claims);
        // 从token中解密获取用户角色
        String[] roles = JwtTokenUtil.getRoles(claims);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        if (null != username) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
                    null, authorities);
            // SecurityContextHolder.getContext().setAuthentication(authentication);
            super.doFilterInternal(request, response, chain);
        }

    }
}
