package edu.umich.api.tester.wso2.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "API")
public class GetAPIsAPI {
	@XmlElement(name = "api_id")
	private int apiId;
	@XmlElement(name = "http_method")
	private String httpMethod;
	@XmlElement(name = "auth_scheme")
	private String authScheme;
	@XmlElement(name = "url_pattern")
	private String urlPattern;
	@XmlElement(name = "testRequest")
	private String testRequest;
	@XmlElement(name = "testResponse")
	private String testResponse;
	@XmlElement(name = "api_name")
	private String apiName;
	@XmlElement(name = "api_version")
	private String apiVersion;
	@XmlElement(name = "context")
	private String context;
}
