package edu.umich.api.tester.wso2;

import java.security.KeyStore;

public class Wso2Credentials {
	/**
     * The customer value provided by wso2.
     */
    private String customer;

    /**
     * The secret value provided by wso2.
     */
    private String secret;

    /**
     * The token url. For example https://api-km.it.umich.edu/token.
     */
    private String tokenUrl;

    /**
     * A trust store that contains the certs for wso2. I used keytool to build a
     * truststore and added the cert. The cert and truststore are in the
     * src/test/resources directory.
     */
    private KeyStore trustStore;

    /**
     * A wso2Token object populated by the Wso2TokenDao when calling the
     * tokenUrl with the customer and secret value.
     */
    private Wso2Token wso2Token;

    /**
     * The Customer provided by wso2.
     * @return the customer value.
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Sets the customer provide by wso2.
     * @param customer the customer provided by wso2.
     */
    public void setCustomer(final String customer) {
        this.customer = customer;
    }

    /**
     * Get the secret provided by wso2.
     * @return gets the secret provided by wso2.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Sets the secret provided by wso2.
     * @param secret provided by wso2.
     */
    public void setSecret(final String secret) {
        this.secret = secret;
    }

    /**
     * The token url used to get an access token.
     * @return the token url provided by wso2.
     */
    public String getTokenUrl() {
        return tokenUrl;
    }

    /**
     * Gets the url used to get the token from wso2.
     * @param tokenUrl the url used to get the token from wso2.
     */
    public void setTokenUrl(final String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    /**
     * Sets the keystore used for the ssl connection.
     * @see KeyStoreHelper to read a keystore from the file system.
     * @param trustStore the keystore that has the certs used to connect to
     *            wso2.
     */
    public void setTrustStore(final KeyStore trustStore) {
        this.trustStore = trustStore;
    }

    /**
     * Gets the TrustStore used for the ssl connection.
     * @return a truststore used for the ssl connection.
     */
    public KeyStore getTrustStore() {
        return trustStore;
    }

    /**
     * Gets the Wso2Token that has the access token for making web service
     * calls.
     * @return a wso2Token.
     */
    public Wso2Token getWso2Token() {
        return wso2Token;
    }

    /**
     * Sets the wso2Token. This is set after the Wso2TokenDao has retrieved the
     * token.
     * @param wso2Token the token to set.
     */
    public void setWso2Token(final Wso2Token wso2Token) {
        this.wso2Token = wso2Token;
    }
}
