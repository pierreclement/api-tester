package edu.umich.api.tester.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EndpointResponse {

    private String url;
    private Date date;
    private String rawRequest;
    private String rawResponse;
    private List<TestCaseResponse> testCases;
}
