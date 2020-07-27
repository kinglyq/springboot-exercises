package priv.lyq.springboot.common.response;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * 接口数据响应类
 *
 * @author Li Yuqing
 * @date 2020-07-20 17:00:00
 */
public class ResponseResult extends HashMap<String, Object> {

    public static final int INITIAL_CAPACITY = 16;

    /**
     * 业务处理成功
     *
     * @return {@link ResponseResult}
     */
    public static ResponseResult success() {
        return ResponseResult.success(null);
    }

    /**
     * 业务处理成功，使用{@code ResponseStatus.OK}的reasonPhrase作msg，不接受自定义
     *
     * @param data 具体数据
     * @return {@link ResponseResult}
     */
    public static ResponseResult success(Object data) {
        ResponseStatus ok = ResponseStatus.OK;
        return new ResponseResult(ok.code, ok.reasonPhrase, data);
    }

    /**
     * 业务处理错误，msg默认为{@code ResponseStatus}的reasonPhrase
     *
     * @param status {@link ResponseStatus}
     * @return {@link ResponseResult}
     */
    public static ResponseResult error(ResponseStatus status) {
        return new ResponseResult(status.code, status.reasonPhrase, null);
    }

    /**
     * 业务处理错误
     *
     * @param status {@link ResponseStatus}
     * @param msg    错误提示信息，不写默认为{@code ResponseStatus}的reasonPhrase
     * @param data   没啥放的可以放出错的堆栈信息
     * @return {@link ResponseResult}
     */
    public static ResponseResult error(ResponseStatus status, String msg, Object data) {
        if(StringUtils.isBlank(msg)){
            msg = status.reasonPhrase;
        }
        return new ResponseResult(status.code, msg, data);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public ResponseResult() {
        super(INITIAL_CAPACITY);
    }

    public ResponseResult(int code, String msg, Object data) {
        super(INITIAL_CAPACITY);
        put("code", code);
        put("msg", msg);
        put("data", data);
    }

}
