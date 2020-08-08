package top.funsite.springboot.web.http.exception;

/**
 * <p>451 Unavailable For Legal Reasons</p>
 * 用户请求非法资源，例如：由政府审查的网页
 *
 * @author Li Yuqing
 * @date 2020-08-07 18:55:36
 */
public class UnavailableForLegalReasonsException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public UnavailableForLegalReasonsException(String message) {
        super(message);
    }
}
