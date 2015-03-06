package edu.umich.api.tester.wso2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wso2Token {

    /**
     * The token type returned from wso2.
     */
    @JsonProperty("token_type")
    private String type;

    /**
     * The seconds that the token has till it expires.
     */
    @JsonProperty("expires_in")
    private int expires;

    /**
     * The access token used when making calls to wso2 web services.
     */
    @JsonProperty("access_token")
    private String accessToken;
}
