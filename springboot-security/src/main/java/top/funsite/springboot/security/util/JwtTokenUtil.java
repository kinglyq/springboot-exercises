package top.funsite.springboot.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import top.funsite.springboot.security.config.autoconfigure.JwtTokenProperties;

import java.util.Date;

/**
 * token生成、校验
 *
 * @author Li Yuqing
 * @date 2020-05-24 09:30:00
 */
@Slf4j
public class JwtTokenUtil {

    /**
     * Token请求头
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 用户名声明
     */
    private static final String USERNAME = "username";

    /**
     * 角色声明
     */
    private static final String ROLES = "roles";

    /**
     * token解析错误
     */
    private static final String TOKEN_PARSING_ERROR = "token解析错误";

    /**
     * 生成token
     *
     * @param username 用户名
     * @param roles    角色
     * @return token
     */
    public static String createToken(String username, String roles) {
        return Jwts
                .builder()
                .setSubject(JwtTokenProperties.subject)
                // .setClaims(map)
                .claim(USERNAME, username)
                .claim(ROLES, roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtTokenProperties.expiration.getSeconds()))
                .signWith(SignatureAlgorithm.HS256, JwtTokenProperties.appSecretKey).compact();
    }

    /**
     * 校验token
     *
     * @param token token
     * @return token body
     */
    public static Claims checkToken(String token) {
        try {
            return Jwts.parser().setSigningKey(JwtTokenProperties.appSecretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error(TOKEN_PARSING_ERROR);
            return null;
        }
    }

    /**
     * 从token Body中根据key获取value
     *
     * @param token token
     * @param key   key
     * @return value
     */
    public static String getTokenBodyValue(String token, String key) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, TOKEN_PARSING_ERROR);
        return claims.get(key).toString();
    }

    /**
     * 获取用户名
     *
     * @param token token
     * @return 用户名
     */
    public static String getUsername(String token) {
        return getTokenBodyValue(token, USERNAME);
    }

    /**
     * 获取角色
     *
     * @param token token
     * @return 角色数组
     */
    public static String[] getRoles(String token) {
        String listRole = getTokenBodyValue(token, ROLES);
        return StringUtils.strip(listRole, "[]").split(", ");
    }

    /**
     * 校验token是否过期
     *
     * @param token token
     * @return true=过期
     */
    public static boolean isExpired(String token) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, TOKEN_PARSING_ERROR);
        return claims.getExpiration().before(new Date());
    }

    private JwtTokenUtil() {
    }
}
