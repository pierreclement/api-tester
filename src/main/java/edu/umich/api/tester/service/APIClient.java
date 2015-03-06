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
    public APIResponse invoke(APIRequest apiRequest) {
        APIResponse apiResponse = assemble(apiRequest);
        //restTemplate...
        return apiResponse;
    }
    
    private APIResponse assemble(APIRequest apiRequest) {
         APIResponse apiResponse  = new APIResponse();
         apiResponse.setStatusCode(200);
         apiResponse.setStatusMessage("OK");
         return apiResponse;
    }
}
