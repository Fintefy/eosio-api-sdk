package one.eosio.api.sdk.auth.request;

import one.eosio.api.sdk.auth.domain.UserRegister;
import one.eosio.api.sdk.auth.response.UserRegisterResponse;
import one.eosio.api.sdk.base.domain.HTTPMethod;
import one.eosio.api.sdk.base.exception.EosException;
import one.eosio.api.sdk.base.request.EosBaseRequest;
import one.eosio.api.sdk.util.EOSJsonUtil;

/**
 * EOS auth register request
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EosAuthRegisterRequest extends EosBaseRequest<UserRegisterResponse> {

    public EosAuthRegisterRequest(UserRegister userRegister) throws EosException {
        super();
        this.method = HTTPMethod.POST;
        this.path = "v1/auth/register";
        this.body = EOSJsonUtil.beanToJson(userRegister);
    }

    /**
     * convert response json to Bean
     *
     * @return
     * @throws EosException
     */
    @Override
    public UserRegisterResponse createResponse() throws EosException {
        return EOSJsonUtil.jsonToBean(executeRequest(), UserRegisterResponse.class);
    }

}
