package one.eosio.api.sdk.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import one.eosio.api.sdk.base.exception.EosException;

import java.io.IOException;

/**
 * EOS Json Util
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EOSJsonUtil {

    private static ObjectMapper mapper;

    public static <T> T jsonToBean(String jsonStr, Class<T> cls) throws EosException {
        try {
            return getMapper().readValue(jsonStr, cls);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EosException(e.getMessage());
        }
    }

    private static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return mapper;
    }

    public static String beanToJson(Object src) throws EosException {
        try {
            // Convert object to JSON string
            return getMapper().writeValueAsString(src);
        } catch (JsonProcessingException e) {
            throw new EosException(e.getMessage());
        }
    }
}
