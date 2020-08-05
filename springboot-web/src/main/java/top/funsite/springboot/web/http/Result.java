package top.funsite.springboot.web.http;

import java.util.HashMap;

/**
 * 接口统一返回实体
 *
 * @author Li Yuqing
 * @date 2020-08-05 11:45:59
 */
public class Result extends HashMap<String, Object> {

    private static final int INITIAL_CAPACITY = 16;

    public Result() {
        super(INITIAL_CAPACITY);
    }

    public Result(String message) {
        super(INITIAL_CAPACITY);
        put("message", message);
    }

    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

}
