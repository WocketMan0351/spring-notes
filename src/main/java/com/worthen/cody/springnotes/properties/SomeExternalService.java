package com.worthen.cody.springnotes.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

	// external.service.url (inside src/main/resources/app.properties)
	@Value("${external.service.url}") // grabs the value associated with this key
	private String url;

	public String returnServiceURL() {
		return url;
	}

}
