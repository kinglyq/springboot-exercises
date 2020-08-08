package top.funsite.springboot.web.http.exception;

/**
 * <p>429 Too Many Requests</p>
 * 用户在给定的时间内发送了太多请求（“限制请求速率”）
 *
 * @author Li Yuqing
 * @date 2020-08-07 17:44:32
 */
public class TooManyRequestsException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public TooManyRequestsException(String message) {
        super(message);
    }
}
