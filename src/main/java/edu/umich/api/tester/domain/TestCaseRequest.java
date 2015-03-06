package edu.umich.api.tester.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class TestCaseRequest implements Serializable {

    private String testCondition;
}
