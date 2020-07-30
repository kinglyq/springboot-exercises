package com.github.kinglyq.common.http.response;

import com.github.kinglyq.common.http.HttpStatus;
import org.apache.commons.lang3.StringUtils;

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
     * @return {@link Result}
     */
    public static Result success() {
        return Result.success(null);
    }

    /**
     * 业务处理成功，使用{@code ResponseStatus.OK}的reasonPhrase作msg，不接受自定义
     *
     * @param data 具体数据
     * @return {@link Result}
     */
    public static Result success(Object data) {
        HttpStatus ok = HttpStatus.OK;
        return new Result(ok.code, ok.reasonPhrase, data);
    }

    /**
     * 业务处理错误，msg默认为{@code ResponseStatus}的reasonPhrase
     *
     * @param status {@link HttpStatus}
     * @return {@link Result}
     */
    public static Result error(HttpStatus status) {
        return new Result(status.code, status.reasonPhrase, null);
    }

    /**
     * 业务处理错误
     *
     * @param status {@link HttpStatus}
     * @param msg    错误提示信息，不写默认为{@code ResponseStatus}的reasonPhrase
     * @param data   没啥放的可以放出错的堆栈信息
     * @return {@link Result}
     */
    public static Result error(HttpStatus status, String msg, Object data) {
        if(StringUtils.isBlank(msg)){
            msg = status.reasonPhrase;
        }
        return new Result(status.code, msg, data);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public Result() {
        super(INITIAL_CAPACITY);
    }

    public Result(int code, String msg, Object data) {
        super(INITIAL_CAPACITY);
        put("code", code);
        put("msg", msg);
        put("data", data);
    }

}
