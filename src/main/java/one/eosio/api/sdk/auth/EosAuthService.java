package one.eosio.api.sdk.auth;

import one.eosio.api.sdk.auth.response.UserRegisterResponse;
import one.eosio.api.sdk.auth.domain.UserRegister;
import one.eosio.api.sdk.auth.request.EosAuthRegisterRequest;

/**
 * EOS Auth Service
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EosAuthService {

    /**
     * register eos user account
     *
     * @param userRegister
     * @return
     */
    public UserRegisterResponse register(final UserRegister userRegister) {
        return new EosAuthRegisterRequest(userRegister).createResponse();
    }

}
