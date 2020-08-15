package top.funsite.springboot.security.http.response;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.HashMap;

/**
 * 定义接口返回Json的数据格式
 *
 * @author Li Yuqing
 * @date 2020-07-20 17:00:00
 */
public class Result extends HashMap<String, Object> {

    public static final int INITIAL_CAPACITY = 16;

    /**
     * 业务处理成功
     *
     * @param msg  消息提示
     * @param data 数据
     * @return {@link Result}
     */
    public static Result success(String msg, Object data) {
        return new Result(ResponseStatus.OK, msg, null, data);
    }

    /**
     * 业务处理成功
     *
     * @return {@link Result}
     */
    public static Result success() {
        return Result.success(null, null);
    }

    /**
     * 业务处理成功
     *
     * @param msg 消息提示
     * @return {@link Result}
     */
    public static Result success(String msg) {
        return Result.success(msg, null);
    }

    /**
     * 业务处理成功
     *
     * @param data 数据
     * @return {@link Result}
     */
    public static Result success(Object data) {
        return Result.success(null, data);
    }


    /**
     * 业务处理错误
     *
     * @param status {@link ResponseStatus}
     * @param msg    错误提示
     * @param e      异常
     * @param data   数据
     * @return {@link Result}
     */
    public static Result error(ResponseStatus status, String msg, Exception e, Object data) {
        return new Result(status, msg, e, data);
    }

    /**
     * 业务处理错误
     *
     * @param status {@link ResponseStatus}
     * @param msg    错误提示
     * @param e      异常
     * @return {@link Result}
     */
    public static Result error(ResponseStatus status, String msg, Exception e) {
        return Result.error(status, msg, e, null);
    }

    /**
     * 业务处理错误
     *
     * @param status {@link ResponseStatus}
     * @param msg    错误提示
     * @return {@link Result}
     */
    public static Result error(ResponseStatus status, String msg) {
        return Result.error(status, msg, null);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public Result(ResponseStatus status, String msg, Exception e, Object data) {
        super(INITIAL_CAPACITY);
        Assert.notNull(status, "ResponseStatus can not be null");
        put("code", status.code);
        if (!StringUtils.isNotBlank(msg)) {
            msg = status.reasonPhrase;
        }
        put("msg", msg);
        if (null != e) {
            put("cause", e.getMessage());
        }
        if (null != data) {
            put("data", data);
        }
    }

}
