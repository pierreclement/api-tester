package edu.umich.api.tester.domain;

import java.net.URI;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EndpointRequest {

    private URI url;
    private String verb;
    private Date date;
    private String fullRequest;
    private String expectedResponse;
    private List<TestCaseRequest> testCases;
}
