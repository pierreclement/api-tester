package edu.umich.api.tester.web;

import edu.umich.api.tester.domain.API;
import edu.umich.api.tester.service.APIService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apis")
public class APIsMvcController {

    @Autowired
    private APIService service;
    @Autowired
    private APIsResourceAssembler assembler;
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger("edu.umich.api.tester");

    @RequestMapping("")
    public API hello() {
        return new API();
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<APIsResource> findById(@RequestBody @PathVariable Long id) {
        List<API> apis = service.getAPIs();
        APIsResource resource = assembler.toResource(apis);
        ResponseEntity<APIsResource> response = new ResponseEntity<>(resource, HttpStatus.OK);
        return response;
    }
}
