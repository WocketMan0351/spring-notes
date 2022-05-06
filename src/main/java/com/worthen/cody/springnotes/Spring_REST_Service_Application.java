package com.worthen.cody.springnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

// fixes an error with auto config and spring boot starter data jpa
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Spring_REST_Service_Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(Spring_REST_Service_Application.class);

		// prints all the beans that are auto configured by spring boot
//		for (String beanName : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(beanName);
//		}
	}

}
