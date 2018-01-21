package one.eosio.api.sdk.base.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Eos Base Response
 *
 * @author wangwei
 * @date 2018/01/21
 */
@Data
public class EosBaseResponse {

    @JsonProperty("code")
    protected long code;

    @JsonProperty("message")
    protected String message;

    @JsonProperty("details")
    protected String details;

}
