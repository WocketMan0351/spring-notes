package com.worthen.cody.springnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.worthen.cody.component_scan.ComponentDao;

/**
 * @SpringBootApplication tells Spring to scan the current package and all of
 *                        its sub-packages. If we want to scan other packages,
 *                        such as component_scan package in this case, we need
 *                        to use the @ComponentScan annotation as shown below.
 * 
 *                        Only things found during the component scan are
 *                        eligible to become beans.
 */
@SpringBootApplication
@ComponentScan("com.worthen.cody.component_scan") // pass the additional package(s) to scan for eligible beans
public class SpringComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringComponentScanApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringComponentScanApplication.class, args);

		ComponentDao componentDao = (ComponentDao) applicationContext.getBean("componentDao");

		LOGGER.info("{}", componentDao);
	}

}
