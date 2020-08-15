package top.funsite.springboot.security.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson的简单封装
 *
 * @author Li Yuqing
 * @date 2020-07-21 10:37:00
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String writeValueAsString(Object data) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(data);
    }

    public static String writeValueAsStringPretty(Object data) throws JsonProcessingException {
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public static <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(content, valueType);
    }

    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        return OBJECT_MAPPER.readValue(content, valueTypeRef);
    }

    private JsonUtils() {
    }

}
