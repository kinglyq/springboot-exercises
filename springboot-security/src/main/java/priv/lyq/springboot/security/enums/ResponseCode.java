package priv.lyq.springboot.security.enums;

/**
 * @author Yuqing Li
 */
public enum ResponseCode {

    /**
     * 未知错误
     */
    UNKNOWN_MISTAKE(-1, "未知错误"),

    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),

    /**
     * 用户未登录
     */
    USER_IS_NOT_LOGGED_IN(1, "用户未登录"),

    /**
     * 用户不存在
     */
    USER_NOT_FOUND(2, "用户不存在"),

    /**
     * 密码错误
     */
    WRONG_PASSWORD(3, "密码错误"),

    /**
     * token过期
     */
    TOKEN_EXPIRED(4, "token过期"),

    /**
     * token解析错误
     */
    TOKEN_PARSING_ERROR(5, "token解析错误"),

    /**
     * 账号过期
     */
    ACCOUNT_EXPIRED(6, "账号过期"),

    /**
     * 密码过期
     */
    PASSWORD_EXPIRED(7, "密码过期"),

    /**
     * 账号不可用
     */
    ACCOUNT_UNAVAILABLE(8, "账号不可用"),

    /**
     * 账号被锁定
     */
    ACCOUNT_LOCKED(9, "账号被锁定");

    public int code;

    public String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
