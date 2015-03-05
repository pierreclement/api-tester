package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class APIsResourceAssembler {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    public APIsResource toResource(API api) {
       // APIsResource res = new APIsResource(api);
        //return res;
        return null;
    }
}
