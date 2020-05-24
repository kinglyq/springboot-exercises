package priv.lyq.sboot.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuqing li
 */
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
    public static final String SUBJECT = "sboot";

    /**
     * 过期时间
     */
    public static final long EXPIRATION = 1000 * 24 * 60 * 60 * 7;

    /**
     * 应用密钥
     */
    public static final String APP_SECRET_KEY = "springSecurity";

    /**
     * 角色权限声明
     */
    private static final String ROLE_CLAIMS = "role";

    /**
     * 生成Token
     */
    public static String createToken(String username, String roles) {
        return Jwts
                .builder()
                .setSubject(SUBJECT)
                // .setClaims(map)
                .claim("username", username)
                .claim("roles", roles)
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
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从Token中获取username
     */
    public static String getTokenBodyValue(String token, String key) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, "token解析错误");
        return claims.get(key).toString();
    }

    /**
     * 校验Token是否过期
     */
    public static boolean isExpiration(String token) {
        Claims claims = checkToken(token);
        Assert.notNull(claims, "token解析错误");
        return claims.getExpiration().before(new Date());
    }

}
