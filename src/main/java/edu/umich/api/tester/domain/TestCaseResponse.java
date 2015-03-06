package edu.umich.api.tester.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TestCaseResponse implements Serializable {

    private String testCondition;
    private boolean success;
    private String details;
}
