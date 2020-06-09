package priv.lyq.springboot.multipleds.entity;

import priv.lyq.springboot.multipleds.enums.ResponseCode;

import java.util.HashMap;

/**
 * @author Yuqing Li
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 8374868085789893949L;

    private static final int INITIAL_CAPACITY = 16;

    public static Result success() {
        Result result = new Result();
        result.put("code", ResponseCode.SUCCESS.code);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.put("code", ResponseCode.SUCCESS.code);
        result.put("msg", msg);
        return result;
    }

    public static Result success(String msg, Object data) {
        return new Result(ResponseCode.SUCCESS.code, msg, data);
    }

    public static Result error(int code, String msg) {
        if (code == 0) {
            throw new IllegalArgumentException("错误代码不能为0");
        }
        Result result = new Result(code, msg, null);
        result.remove("data");
        return result;
    }

    public static Result error(int code, String msg, Object data) {
        Result result = Result.error(code, msg);
        result.put("data", data);
        return result;
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
