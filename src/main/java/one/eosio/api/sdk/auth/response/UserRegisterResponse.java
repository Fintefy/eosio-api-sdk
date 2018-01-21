package one.eosio.api.sdk.auth.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import one.eosio.api.sdk.auth.domain.Token;
import one.eosio.api.sdk.base.response.EosBaseResponse;

/**
 * user register response
 *
 * @author wangwei
 * @date 2018/01/21
 */
@Data
public class UserRegisterResponse extends EosBaseResponse {

    /**
     * token
     */
    @JsonProperty("token")
    private Token token;

}
