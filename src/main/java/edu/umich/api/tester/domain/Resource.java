package edu.umich.api.tester.domain;

import java.net.URI;

import javax.validation.constraints.NotNull;

public class Resource {
	@NotNull
	private URI url;

	public URI getUrl() {
		return url;
	}

	public void setUrl(URI url) {
		this.url = url;
	}
}
