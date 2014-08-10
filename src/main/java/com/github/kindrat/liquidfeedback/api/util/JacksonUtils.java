package com.github.kindrat.liquidfeedback.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.joda.JodaMapper;

import java.io.IOException;

/**
 * Provides functionality related to Java-JSON (de)serialization with Jackson.
 */
public class JacksonUtils {
    private static final JodaMapper OBJECT_MAPPER = new JodaMapper();

    static {
        OBJECT_MAPPER.setWriteDatesAsTimestamps(false);
    }

    /**
     * Serializes an object to JSON.
     *
     * @param value the object to serialize
     * @return the serialized object in JSON
     */
    public static String toJson(Object value) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(value);
    }

    /**
     * Deserializes JSON to a Java object.
     *
     * @param json  the object in JSON
     * @param clazz the class of the object to deserialize
     * @return the deserialized object
     */
    public static <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    /**
     * Deserializes JSON to a generic Java object .
     *
     * @param json              the object in JSON
     * @param parametrizedClass the generic class of the object to deserialize
     * @param parameterTypes    the parameter classes of parametrized class
     * @return deserialized object
     */
    public static <T> T fromJsonAsParametrized(String json, Class<T> parametrizedClass, Class<?>... parameterTypes) throws IOException {
        JavaType parametricType = constructParametricType(parametrizedClass, parameterTypes);
        return OBJECT_MAPPER.readValue(json, parametricType);
    }

    /**
     * Deserializes JSON to a generic Java object .
     *
     * @param json              the object in JSON
     * @param parametrizedClass the generic class of the object to deserialize
     * @param parameterTypes    the parameter classes of parametrized class
     * @return deserialized object
     */
    public static <T> T fromJsonAsParametrized(String json, Class<T> parametrizedClass, JavaType... parameterTypes) throws IOException {
        if (parameterTypes != null && parameterTypes.length > 0) {
            JavaType parametricType = constructParametricType(parametrizedClass, parameterTypes);
            return OBJECT_MAPPER.readValue(json, parametricType);
        }
        return OBJECT_MAPPER.readValue(json, parametrizedClass);
    }

    private static TypeFactory getTypeFactory() {
        return OBJECT_MAPPER.getTypeFactory();
    }

    /**
     * Constructs a parametric type.
     *
     * @param parametrizedClass the parametrized class
     * @param parameterTypes     the parameter classes
     * @return the parametric java type
     */
    public static <T> JavaType constructParametricType(Class<T> parametrizedClass, JavaType... parameterTypes) {
        return getTypeFactory().constructParametricType(parametrizedClass, parameterTypes);
    }

    public static <T> JavaType constructParametricType(Class<T> parametrizedClass, Class<?>... parameterTypes) {
        return getTypeFactory().constructParametricType(parametrizedClass, parameterTypes);
    }
}