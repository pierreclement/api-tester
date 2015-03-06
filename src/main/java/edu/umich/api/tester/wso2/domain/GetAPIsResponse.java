package edu.umich.api.tester.wso2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "APIs")
public class GetAPIsResponse {
	private List<GetAPIsAPI> apis;

	public GetAPIsResponse() {
		apis = new ArrayList<GetAPIsAPI>();
	}
}
