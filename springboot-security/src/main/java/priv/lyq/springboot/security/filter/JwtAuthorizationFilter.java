package priv.lyq.springboot.security.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import priv.lyq.springboot.security.entity.Result;
import priv.lyq.springboot.security.enums.ResponseCode;
import priv.lyq.springboot.security.util.JwtTokenUtil;

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
 * @author Yuqing Li
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String token = request.getHeader(JwtTokenUtil.TOKEN_HEADER.toLowerCase());
        // 若请求头中没有Authorization或是不以Bearer 开头 则直接放行
        if (token == null || !token.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        // 去掉前缀 获取Token字符串
        token = token.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        Claims claims = JwtTokenUtil.checkToken(token);
        ResponseCode resp;
        // token解析错误
        if (null == claims) {
            resp = ResponseCode.TOKEN_PARSING_ERROR;
            response.getWriter().write(JSON.toJSONString(Result.error(resp.code, resp.desc)));
            return;
        }
        // token过期
        if (JwtTokenUtil.isExpiration(token)) {
            resp = ResponseCode.TOKEN_EXPIRED;
            response.getWriter().write(JSON.toJSONString(Result.error(resp.code, resp.desc)));
            return;
        }
        // 从token中解密获取用户名
        String username = JwtTokenUtil.getTokenBodyValue(token, "username");
        // 从token中解密获取用户角色
        String roleList = JwtTokenUtil.getTokenBodyValue(token, "roles");
        // 将角色字符串转换为数组
        String[] roles = StringUtils.strip(roleList, "[]").split(", ");
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
