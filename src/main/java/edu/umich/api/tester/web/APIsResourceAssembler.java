package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.API;
import edu.umich.api.tester.domain.APIs;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class APIsResourceAssembler {

    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    public APIsResource toResource(APIs apis) {
        APIsResource res = new APIsResource(apis);
        return res;
    }
    public APIsResource toResource(List<API> apis) {
        APIsResource res = new APIsResource(apis);
        return res;
    }
}
