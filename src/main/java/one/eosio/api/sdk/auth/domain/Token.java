package one.eosio.api.sdk.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * User Token
 */
@Data
public class Token {

    /**
     * User's id
     */
    private String id;
    /**
     * User's name
     */
    private String name;
    /**
     * User's email
     */
    private String email;
    /**
     * User's role
     */
    private String role;
    /**
     * Access Token's type
     */
    private String tokenType;
    /**
     * Authorization Token
     */
    private String accessToken;
    /**
     * Token to get a new accessToken after expiration time
     */
    private String refreshToken;
    /**
     * Access Token's expiration time in miliseconds
     */
    private Long expiresIn;
    /**
     * The server's Timezone
     */
    private String timezone;
    /**
     * Timestamp
     */
    private Date createdAt;
}
