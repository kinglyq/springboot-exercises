package priv.lyq.springboot.simpleweb.enums;

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
     * 用户不存在
     */
    USER_NOT_FOUND(1, "用户不存在"),

    /**
     * 密码错误
     */
    WRONG_PASSWORD(2, "密码错误"),

    /**
     * token过期
     */
    TOKEN_EXPIRED(3, "token过期"),

    /**
     * token解析错误
     */
    TOKEN_PARSING_ERROR(4, "token解析错误"),

    /**
     * 账号过期
     */
    ACCOUNT_EXPIRED(5, "账号过期"),

    /**
     * 密码过期
     */
    PASSWORD_EXPIRED(6, "密码过期"),

    /**
     * 账号不可用
     */
    ACCOUNT_UNAVAILABLE(7, "账号不可用"),

    /**
     * 账号被锁定
     */
    ACCOUNT_LOCKED(8, "账号被锁定");

    public int code;

    public String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
