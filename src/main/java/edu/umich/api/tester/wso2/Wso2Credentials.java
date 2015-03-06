package edu.umich.api.tester.wso2;

import java.security.KeyStore;
import lombok.Data;

@Data
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
}
