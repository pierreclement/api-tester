package edu.umich.api.tester.service;

import edu.umich.api.tester.domain.API;
import edu.umich.api.tester.domain.APIRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class APIService {

    @Autowired
    private APIRepository repo;
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    @Transactional(readOnly = true)
    public List<API> getAPIs() {
        logger.error("hello");
        return null;
    }
}
