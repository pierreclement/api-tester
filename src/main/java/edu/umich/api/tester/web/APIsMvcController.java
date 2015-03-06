package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.APIResponses;
import edu.umich.api.tester.service.APITesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis")
public class APIsMvcController {

    @Autowired
    private APITesterService service;
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    @RequestMapping("")
    public APIResponses getAll() {
        return service.invokeAllAPIRequests();
    }
}
