package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.API;
import edu.umich.api.tester.domain.APIRepository;
import edu.umich.api.tester.domain.APIs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class APITesterService {

    @Autowired
    private APIRepository repo;
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    @Transactional(readOnly = true)
    public APIs invokeAll() {
        APIs apis = new APIs(repo.findAll());
        logger.info("found " + apis.getApis().size() + " apis to invoke");
        for (API api : apis.getApis()) {
            System.err.println("");
        }
        return apis;
    }
}
