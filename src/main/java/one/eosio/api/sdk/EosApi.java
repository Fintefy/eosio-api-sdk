package one.eosio.api.sdk;

import one.eosio.api.sdk.auth.domain.UserRegister;
import one.eosio.api.sdk.auth.response.UserRegisterResponse;

/**
 * EOS API Interface
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EosApi {

    private EosServiceFactory factory;

    private synchronized EosServiceFactory getFactory() {
        if (factory == null) {
            factory = new EosServiceFactory();
        }
        return factory;
    }

    /**
     * User register api
     *
     * @param userRegister
     * @return
     */
    public UserRegisterResponse registerUser(final UserRegister userRegister) {
        return this.getFactory().getEosAuthService().register(userRegister);
    }

}
