package top.funsite.springboot.security.http.response;

/**
 * 接口响应码与描述，参照HttpStatus
 * <ul>
 *     <li>200 成功</li>
 *     <li>4xx 客户端错误</li>
 *     <li>500 服务器端<strong>未知</strong>错误</li>
 *     <li>5xx 可以确定的服务器端错误</li>
 *     <li>6xx 用户相关（登录、账号问题等）</li>
 *     <li>7xx Token相关</li>
 * </ul>
 *
 * @author Li Yuqing
 * @date 2020-07-30 15:31:14
 */
public enum ResponseStatus {

    /**
     * 成功
     */
    OK((short)200, "OK"),

    /**
     * http请求数据解析异常
     */
    BAD_REQUEST((short)400, "Bad Request"),

    /**
     * 请求出现语法错误或参数校验不通过
     */
    UNPROCESSABLE_ENTITY((short)422, "Unprocessable Entity"),

    /**
     * 未经授权（例如：未登录的访问）
     */
    UNAUTHORIZED((short)401, "Unauthorized"),

    /**
     * 资源不可用，通常为无权限（已登录）
     */
    FORBIDDEN((short)403, "Forbidden"),

    /**
     * 无法找到指定位置的资源
     */
    NOT_FOUND((short)404, "Not Found"),

    /**
     * 文档永久地离开了指定的位置
     */
    GONE((short)410, "Gone"),

    /**
     * 服务器端未知错误
     */
    INTERNAL_SERVER_ERROR((short)500, "Internal Server Error"),

    /**
     * 用户未登录
     *
     * @deprecated 使用@{{@link #UNAUTHORIZED}}代替
     */
    @Deprecated
    USER_IS_NOT_LOGGED_IN((short)600, "User Is Not Logged In"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND((short)601, "User Not Found"),

    /**
     * 密码错误
     */
    WRONG_PASSWORD((short)602, "Wrong Password"),

    /**
     * 账号被锁定
     */
    ACCOUNT_LOCKED((short)603, "Account Locked"),

    /**
     * 密码过期
     */
    PASSWORD_EXPIRED((short)604, "Password Expired"),

    /**
     * 账号过期
     */
    ACCOUNT_EXPIRED((short)605, "Account Expired"),

    /**
     * 账号不可用
     */
    ACCOUNT_UNAVAILABLE((short)606, "Account Unavailable"),

    /**
     * token过期
     */
    TOKEN_EXPIRED((short)700, "Token Expired"),

    /**
     * token解析错误
     */
    TOKEN_PARSING_ERROR((short)701, "Token Parsing Error");

    /**
     * 状态码
     */
    public final int code;

    /**
     * 原因描述
     */
    public final String reasonPhrase;

    ResponseStatus(short code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

}
