package top.funsite.springboot.web.http.exception;

/**
 * <p>423 Locked</p>
 * 正在访问的资源被锁定
 *
 * @author Li Yuqing
 * @date 2020-08-07 17:15:47
 */
public class LockedException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public LockedException(String message) {
        super(message);
    }
}
