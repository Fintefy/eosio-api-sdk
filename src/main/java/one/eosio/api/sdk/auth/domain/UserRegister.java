package one.eosio.api.sdk.auth.domain;

import lombok.Data;

/**
 * 用户注册请求类
 *
 * @author wangwei
 * @date 2018/01/21
 */
@Data
public class UserRegister {

    /**
     * email
     */
    private String email;
    /**
     * password
     */
    private String password;

}
