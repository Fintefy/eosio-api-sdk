package one.eosio.api.sdk;

import one.eosio.api.sdk.auth.domain.UserRegister;
import one.eosio.api.sdk.auth.response.UserRegisterResponse;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EosApiTest extends TestNG {

    private EosApi eosApi;

    @BeforeTest
    public void setUp() throws Exception {
        if (eosApi == null) {
            eosApi = new EosApi();
        }
    }

    @Test
    public void testRegisterUser() {
        UserRegister userRegister = new UserRegister();
        userRegister.setEmail("w7years@gmail.com");
        userRegister.setPassword("123456");
        UserRegisterResponse userRegisterResponse = eosApi.registerUser(userRegister);
        Assert.assertNotNull(userRegisterResponse.getToken());
    }

}
