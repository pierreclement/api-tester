package edu.umich.api.tester.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EndpointRequest {

    private String url;
    private String verb;
    private Date date;
    private String fullRequest;
    private String expectedResponse;
    private List<TestCaseRequest> testCaseRequests;

    public List<TestCaseRequest> getTestCaseRequests() {
        if (testCaseRequests == null) {
            testCaseRequests = new ArrayList<>();
        }
        return testCaseRequests;
    }
}
