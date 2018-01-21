package one.eosio.api.sdk.base.domain;

import lombok.Getter;

/**
 * EOS API Http Method
 *
 * @author
 * @date 2018/01/21
 */
@Getter
public enum HTTPMethod {

    GET("GET"), POST("POST"), PUT("PUT"),
    DELETE("DELETE"), PATCH("PATCH"), UPLOAD("UPLOAD");

    private final String name;

    HTTPMethod(String name) {
        this.name = name;
    }

}
