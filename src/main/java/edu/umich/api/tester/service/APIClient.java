package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.APIRequest;
import edu.umich.api.tester.domain.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class APIClient {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    //@Autowired
    //private RestTemplate restTemplate;
    public APIResponse invoke(APIRequest api) {
        return null;
    }
}
