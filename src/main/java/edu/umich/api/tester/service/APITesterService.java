package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.APIRequestRepository;
import edu.umich.api.tester.domain.APIRequests;
import edu.umich.api.tester.domain.APIResponse;
import edu.umich.api.tester.domain.APIResponses;
import edu.umich.api.tester.domain.APIs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class APITesterService {

    @Autowired
    private APIRequestRepository repo;
    @Autowired
    private APIClient client;
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    @Transactional(readOnly = true)
    public APIResponses invokeAllAPIRequests() {
        APIRequests apiRequests = new APIRequests(repo.findAll());
        logger.info("found " + apiRequests.getApiRequests().size() + " api(s) to invoke");
        APIResponses apiResponses = new APIResponses();
        apiRequests.getApiRequests().stream().forEach((api) -> {
            APIResponse apiResponse = client.invoke(api);
            apiResponses.add(apiResponse);
        });
        return apiResponses;
    }

    public void report(APIResponses apiResponses) {
        if (apiResponses == null || apiResponses.getApiResponses().isEmpty()) {
            logger.warn("invoked 0 apis");
        } else {
            logger.info("invoked " + apiResponses.getApiResponses().size() + " api(s)");
        }
    }
}
