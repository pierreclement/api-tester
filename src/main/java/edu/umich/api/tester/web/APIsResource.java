package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.API;
import edu.umich.api.tester.domain.APIs;
import java.util.List;
import org.springframework.hateoas.ResourceSupport;

public class APIsResource extends ResourceSupport {

    public APIs apis;

    public APIsResource() {
    }

    public APIsResource(APIs apis) {
        this.apis = apis;
    }

    public APIsResource(List<API> apis) {
        this.apis = new APIs();
        this.apis.setApis(apis);
    }

    public APIs getAPIs() {
        return apis;
    }
}
