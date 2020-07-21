package priv.lyq.springboot.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Li Yuqing
 * @date 2020-07-21 10:37:00
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String writeValueAsString(Object data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);
    }

    public static String writeValueAsStringPretty(Object data) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public static <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(content, valueType);
    }

    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) throws JsonProcessingException {
        return objectMapper.readValue(content, valueTypeRef);
    }

    private JsonUtils(){}

}
