package priv.lyq.springboot.multipleds.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author Yuqing Li
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
     * 签名主题
     */
    public static final String SUBJECT = "springboot";

    /**
     * 过期时间
     */
    public static final long EXPIRATION = 1000 * 60 * 60 * 24;

    /**
     * 应用密钥
     */
    public static final String APP_SECRET_KEY = "springSecurity";

    /**
     * 角色权限声明
     */
    private static final String ROLE_CLAIMS = "roles";

    /**
     * token解析错误
     */
    private static final String TOKEN_PARSING_ERROR = "token解析错误";

    /**
     * 生成Token
     */
    public static String createToken(String username, String roles) {
        return Jwts
                .builder()
                .setSubject(SUBJECT)
                // .setClaims(map)
                .claim("username", username)
                .claim(ROLE_CLAIMS, roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET_KEY).compact();
    }

    /**
     * 校验Token
     *
     * @param token token
     * @return token body
     */
    public static Claims checkToken(String token) {
        try {
            return Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error(TOKEN_PARSING_ERROR);
            return null;
        }
    }

    /**
     * 从Token Body中根据key获取value
     *
     * @return string
     */
    public static String getTokenBodyValue(String token, String key) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, TOKEN_PARSING_ERROR);
        return claims.get(key).toString();
    }

    /**
     * 校验Token是否过期
     *
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, TOKEN_PARSING_ERROR);
        return claims.getExpiration().before(new Date());
    }
}
