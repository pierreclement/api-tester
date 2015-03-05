package edu.umich.api.tester.wso2;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    /**
     * Gets the type.
     * @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * @param type the type to set.
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * The number of seconds till the token expires.
     * @return the number of seconds till the token expires.
     */
    public int getExpires() {
        return expires;
    }

    /**
     * Sets the number of seconds till the token expires.
     * @param expires the number of seconds till the token expires.
     */
    public void setExpires(final int expires) {
        this.expires = expires;
    }

    /**
     * Gets the access token used to authenticate when calling a wso2 service.
     * @return and access token used to authenticate to wso2.
     */
    public String getAcessToken() {
        return accessToken;
    }

    /**
     * Sets the access Token used to authenticate when calling a wso2 service.
     * @param accessToken the access token used to authenicated when calling a wso2 service.
     */
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }
}
