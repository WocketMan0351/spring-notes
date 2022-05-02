package com.worthen.cody.springnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.worthen.cody.springnotes.cdi.SomeCdiBusiness;

@SpringBootApplication
public class SpringCdiApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringCdiApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(SpringCdiApplication.class, args);

		SomeCdiBusiness business = (SomeCdiBusiness) applicationContext
				.getBean("someCdiBusiness");

		LOGGER.info("{} dao-{}", business, business.getSomeCdiDao());
	}

}
