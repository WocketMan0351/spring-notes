package com.worthen.cody.springnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring_REST_Service_Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(Spring_REST_Service_Application.class);

	}

}
