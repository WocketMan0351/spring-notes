package com.worthen.cody.springnotes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.worthen.cody.springnotes.sorting.BinarySearch;

/**
 * @Configuration - Does what @SpringBootApplication does.
 * @ComponentScan - In order to find our beans, we need to configure a component
 *                scan (Spring Boot was doing this for us).
 */
@Configuration
@ComponentScan
public class SpringWithoutSpringBootApplication {

	public static void main(String[] args) {
		// How we get the application context without Spring Boot
		// wrapping it in a try block automatically closes anything that is
		// AutoCloseable
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringWithoutSpringBootApplication.class)) {
			BinarySearch<Integer> binarySearch = (BinarySearch<Integer>) applicationContext
					.getBean("binarySearch");
			System.out.println(binarySearch);
		}
	}

}
