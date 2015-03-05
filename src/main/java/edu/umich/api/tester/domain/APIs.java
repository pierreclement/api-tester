package edu.umich.api.tester.domain;

import java.util.List;
import lombok.Data;

@Data
public class APIs {

    private List<API> apis;

    public APIs() {
    }

    public APIs(List<API> apis) {
        this.setApis(apis);
    }

	public List<API> getApis() {
		return apis;
	}

	public void setApis(List<API> apis) {
		this.apis = apis;
	}
    
    
}
