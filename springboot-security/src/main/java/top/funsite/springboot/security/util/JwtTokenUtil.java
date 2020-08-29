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
                .setExpiration(new Date(System.currentTimeMillis() + JwtTokenProperties.expiration.toMillis()))
                .signWith(SignatureAlgorithm.HS256, JwtTokenProperties.appSecretKey).compact();
    }

    /**
     * 返回JWT body，失败则抛出异常，见{@link io.jsonwebtoken.JwtParser#parseClaimsJws(String)}，请在调用出做异常处理
     *
     * @param token token
     * @return token body
     */
    public static Claims getJwtBody(String token) {
        return Jwts.parser().setSigningKey(JwtTokenProperties.appSecretKey).parseClaimsJws(token).getBody();
    }

    /**
     * 从token Body中根据key获取value
     *
     * @param token token
     * @param key   key
     * @return value
     */
    public static String getTokenBodyValue(Claims token, String key) {
        Assert.notNull(token, "token cannot be null");
        return token.get(key).toString();
    }

    /**
     * 获取用户名
     *
     * @param token token
     * @return 用户名
     */
    public static String getUsername(Claims token) {
        return getTokenBodyValue(token, USERNAME);
    }

    /**
     * 获取角色
     *
     * @param token token
     * @return 角色数组
     */
    public static String[] getRoles(Claims token) {
        String listRole = getTokenBodyValue(token, ROLES);
        return StringUtils.strip(listRole, "[]").split(", ");
    }

    /**
     * 校验token是否过期
     *
     * @param token JWT body
     * @return true ? yes : not
     * @see Claims
     */
    public static boolean isExpired(Claims token) {
        Assert.notNull(token, TOKEN_PARSING_ERROR);
        return token.getExpiration().before(new Date());
    }

    private JwtTokenUtil() {
    }
}
