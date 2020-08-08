package top.funsite.springboot.web.http.exception;

/**
 * <p>403 Forbidden</p>
 * 服务器已经理解请求，但是拒绝执行它。与 401 响应不同的是，身份验证并不能提供任何帮助，而且这个请求也不应该被重复提交。如果这不是一个 HE-
 * AD 请求，而且服务器希望能够讲清楚为何请求不能被执行，那么就应该在实体内描述拒绝的原因。当然服务器也可以返回一个 404 响应，假如它不希望
 * 让客户端获得任何信息
 *
 * @author Li Yuqing
 * @date 2020-08-07 17:12:06
 */
public class ForbiddenException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ForbiddenException(String message) {
        super(message);
    }
}
