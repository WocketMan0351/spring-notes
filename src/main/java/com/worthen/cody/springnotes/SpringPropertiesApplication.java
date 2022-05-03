package com.worthen.cody.springnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.worthen.cody.springnotes.properties.SomeExternalService;

@SpringBootApplication
@PropertySource("classpath:app.properties") // adds a property source to Spring's environment
public class SpringPropertiesApplication {

	/**
	 * We store application properties in an external location and grab them. This
	 * allows us to configure our application differently for production or
	 * development environments.
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(SpringPropertiesApplication.class);

		SomeExternalService service = (SomeExternalService) applicationContext
				.getBean("someExternalService");
		System.out.println(service);
		System.out.println(service.returnServiceURL());
	}

}
