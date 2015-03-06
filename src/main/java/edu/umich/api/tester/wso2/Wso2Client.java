package edu.umich.api.tester.wso2;

import java.security.GeneralSecurityException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.umich.api.tester.domain.Resource;
import org.slf4j.LoggerFactory;

public class Wso2Client {
	
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    private Wso2Credentials credentials;

    public ResponseEntity<String> consumeResource(Resource res) {
    	ResponseEntity<String> response = null;
        try {
            HttpComponentsClientHttpRequestFactory client = new HttpComponentsClientHttpRequestFactory();
            client.setHttpClient(Wso2ClientHelper.buildSSLClient(getCredentials().getTrustStore()));

            RestTemplate template = new RestTemplate(client);
            template.setMessageConverters(Wso2ClientHelper.getCustomerConverter());

            String bearer = getAcessToken();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + bearer);
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            response = template.exchange(res.getUrl(), HttpMethod.GET, entity, String.class);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * fetches the access token for wso2. It uses the wso2 provide customer and
     * secret to retrieve the access token.
     * @return a Wso2Token the has the access token, type and expire
     *         information.
     */
    public Wso2Token fetchToken() {
        Wso2Token token = null;
        try {
            HttpComponentsClientHttpRequestFactory client = new HttpComponentsClientHttpRequestFactory();
            client.setHttpClient(Wso2ClientHelper.buildSSLClient(getCredentials().getTrustStore()));
            RestTemplate template = new RestTemplate(client);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Basic " + Wso2ClientHelper.getKey(getCredentials()));

            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
            form.add("scope", "PRODUCTION");
            form.add("grant_type", "client_credentials");

            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(form, headers);

            token = template.postForObject(getCredentials().getTokenUrl(), request, Wso2Token.class);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return token;
    }

    /**
     * Gets an access token. if the token is null it gets a new one. This
     * function needs to be enhanced. To include checking if the token is
     * expired.
     * @return an Access Token
     */
    public String getAcessToken() {
        if (getCredentials().getWso2Token() == null) {
            getCredentials().setWso2Token(fetchToken());
        }

        return getCredentials().getWso2Token().getAccessToken();
    }

    /**
     * The wso2Credentials.
     * @return the wso2Credentials.
     */
    public Wso2Credentials getCredentials() {
        return credentials;
    }

    /**
     * Sets the wso2 credentials.
     * @param credentials the credentials to set.
     */
    public void setCredentials(final Wso2Credentials credentials) {
        this.credentials = credentials;
    }
}
