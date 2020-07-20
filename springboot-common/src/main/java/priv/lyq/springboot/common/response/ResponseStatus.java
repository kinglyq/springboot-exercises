package priv.lyq.springboot.common.response;

/**
 * 接口响应码与描述，参照HttpStatus
 * <ul>
 *     <li>200 成功</li>
 *     <li>4xx 客户端错误</li>
 *     <li>500 服务器端错误</li>
 *     <li>6xx 自定义状态</li>
 * </ul>
 *
 * @author Li Yuqing
 * @date 2020/7/20 下午 03:36
 */
public enum ResponseStatus {

    /**
     * 成功
     */
    OK(200, "OK"),

    /**
     * 请求出现语法错误
     */
    BAD_REQUEST(400, "Bad Request"),

    /**
     * 未经授权（例如：未登录的访问）
     */
    UNAUTHORIZED(401, "Unauthorized"),

    /**
     * 资源不可用，通常为无权限（已登录）
     */
    FORBIDDEN(403, "Forbidden"),

    /**
     * 无法找到指定位置的资源
     */
    NOT_FOUND(404, "Not Found"),

    /**
     * 文档永久地离开了指定的位置
     */
    GONE(410, "Gone"),

    /**
     * 服务器端未知错误
     */
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    /**
     * 用户未登录
     */
    USER_IS_NOT_LOGGED_IN(600, "用户未登录"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND(601, "用户不存在"),

    /**
     * 密码错误
     */
    WRONG_PASSWORD(602, "密码错误"),

    /**
     * token过期
     */
    TOKEN_EXPIRED(603, "token过期"),

    /**
     * token解析错误
     */
    TOKEN_PARSING_ERROR(604, "token解析错误"),

    /**
     * 账号过期
     */
    ACCOUNT_EXPIRED(605, "账号过期"),

    /**
     * 密码过期
     */
    PASSWORD_EXPIRED(606, "密码过期"),

    /**
     * 账号不可用
     */
    ACCOUNT_UNAVAILABLE(607, "账号不可用"),

    /**
     * 账号被锁定
     */
    ACCOUNT_LOCKED(608, "账号被锁定");

    /**
     * 状态码
     */
    public final int code;

    /**
     * 原因描述
     */
    public final String reasonPhrase;

    ResponseStatus(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }
}
