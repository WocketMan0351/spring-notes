package com.worthen.cody.springnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.worthen.cody.springnotes.scope.PersonDao;

// BEAN SCOPE
// Singleton (DEFAULT) - one instance per Spring Context 
// Prototype - new bean whenever requested
// Request - one bean per HTTP request 
// Session - one bean per HTTP session

@SpringBootApplication
public class SpringScopeApplication {

	// it's better to use a Logger than printing
	private static Logger LOGGER = LoggerFactory.getLogger(SpringScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringScopeApplication.class, args);

		PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
		PersonDao personDao2 = (PersonDao) applicationContext.getBean("personDao");

		/**
		 * personDao and PersonDao2 are the same bean instances, but we have 2 different
		 * instances of JdbcConnection, which is a dependency of PersonDao. We
		 * accomplished this by using a proxy in the @Scope annotation. A different
		 * JdbcConnection instance is even used on the same PersonDao.
		 * 
		 * We need to use a proxy whenever one of a bean's dependencies has a bean scope
		 * of prototype, else that dependency will not actually get a new bean whenever
		 * requested.
		 * 
		 * This is an important concept to keep in mind because it's important to
		 * minimize object creation to optimize memory usage, computation time, garbage
		 * collection, etc.
		 */
		LOGGER.info("{}", personDao);
		LOGGER.info("{}", personDao.getJdbcConnection());
		LOGGER.info("{}", personDao.getJdbcConnection());

		LOGGER.info("{}", personDao2);
		LOGGER.info("{}", personDao2.getJdbcConnection());

	}

}
