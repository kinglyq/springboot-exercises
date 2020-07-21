package priv.lyq.springboot.common.response;

import java.util.HashMap;

/**
 * 接口数据响应类
 *
 * @author Li Yuqing
 * @date 2020-07-20 17:00:00
 */
public class ResponseResult extends HashMap<String, Object> {

    public static final int INITIAL_CAPACITY = 16;

    public static ResponseResult success() {
        return ResponseResult.success(null);
    }

    public static ResponseResult success(Object data) {
        final ResponseStatus ok = ResponseStatus.OK;
        return new ResponseResult(ok.code, ok.reasonPhrase, data);
    }

    public static ResponseResult error(ResponseStatus status) {
        return new ResponseResult(status.code, status.reasonPhrase, null);
    }

    public static ResponseResult error(ResponseStatus status, Object data) {
        return new ResponseResult(status.code, status.reasonPhrase, data);
    }

    public static ResponseResult error(ResponseStatus status, String msg, Object data) {
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
