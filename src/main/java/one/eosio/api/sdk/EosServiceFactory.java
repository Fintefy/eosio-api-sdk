package one.eosio.api.sdk;

import one.eosio.api.sdk.auth.EosAuthService;

/**
 * Eos Service Factory
 *
 * @author wangwei
 * @date 2018/01/21
 */
public class EosServiceFactory {

    private EosAuthService eosAuthService = null;

    public synchronized EosAuthService getEosAuthService() {
        if (eosAuthService == null) {
            eosAuthService = new EosAuthService();
        }
        return eosAuthService;
    }

    

}
