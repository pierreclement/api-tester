package edu.umich.api.tester.wso2;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


/**
 * A static class used to help connect to wso2. It builds the ssl connection for
 * connecting to wso2. Uses the wso2 cred to build the key. Creates a custom
 * json converter that will ignore properties in the json string that are not in
 * the domain object.
 *
 * @author jbouffor
 */
public class Wso2ClientHelper {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    /**
     * Default private constructor to over load the default public constructor.
     */
    private Wso2ClientHelper() {
    }

    /**
     * Gets a message converter for the spring rest template. This converter is
     * used to replace the default behavior of the message converter. I uses a
     * custom object mapper that ignores properties in the json string that are
     * on in the domain object.
     *
     * @return a message converter.
     */
    public static List<HttpMessageConverter<?>> getCustomerConverter() {
        List<HttpMessageConverter<?>> list = new ArrayList<>();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(getCustomMapper());

        list.add(converter);

        return list;
    }

    /**
     * Gets a custom mapper used to convert the json string to a Domain object.
     * This implementation ignores properties that are not on the domain object.
     *
     * @return an jackson object mapper to convert json to a domain object.
     */
    public static ObjectMapper getCustomMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return mapper;
    }

    /**
     * Combines the customer and secret values as prescribe in the wso2
     * documentation. That is customer:secret encoded as base64 string.
     *
     * @param creds the wso2 credentials.
     * @return the wso2 customer and secret encoded.
     */
    public static String getKey(Wso2Credentials creds) {
        String key = creds.getCustomer() + ":" + creds.getSecret();
        return Base64.encodeBase64String(key.getBytes(Charset.defaultCharset()));
    }

    /**
     * Builds an sslClient using a provided keystore. The code may run using the
     * default keystore, but this allows a keystore to be predetermined.
     *
     * @param trustStore the cacerts trust store.
     * @return an SSL connection.
     * @throws GeneralSecurityException and exception if the connection cann't
     * be established.
     */
    public static CloseableHttpClient buildSSLClient(KeyStore trustStore) throws GeneralSecurityException {
        SSLContext context = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();

        String[] protocol = {"TLSv1"};
        SSLConnectionSocketFactory ssl = new SSLConnectionSocketFactory(context, protocol, null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);

        HttpClientBuilder builder = HttpClients.custom();
        builder.setSSLSocketFactory(ssl);

        CloseableHttpClient client = builder.build();
        return client;
    }
}
