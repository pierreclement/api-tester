package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.APIs;
import org.springframework.hateoas.ResourceSupport;

public class APIsResource extends ResourceSupport {

    public APIs apis;

    public APIsResource() {
    }

    public APIsResource(APIs apis) {
        this.apis = apis;
    }

    public APIs getAPIs() {
        return apis;
    }
}
