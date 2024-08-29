package formCustomer.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record RestBean<T>(int code, T data, String message) {
    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(200, data, "請求成功");
    }

    public static <T> RestBean<T> success(T data, String message) {
        return new RestBean<>(200, data, message);
    }

    public static <T> RestBean<T> success() {
        return success(null);
    }

    public static <T> RestBean<T> unauthorized(String message) {
        return failure(401, message);
    }

    public static <T> RestBean<T> forbidden(String message) {
        return failure(403, message);
    }

    public static <T> RestBean<T> failure(int code, String message) {
        return new RestBean<>(code, null, message);
    }

    // 使用 Jackson 將對象轉換為 JSON 字符串
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        // 確保包括 null 值
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }
}
