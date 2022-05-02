package com.worthen.cody.springnotes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.worthen.cody.springnotes.xml.XMLPersonDao;

/**
 * We defined our own custom component scan in our applicationContext.xml file
 */
public class XmlContextSpringApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(XmlContextSpringApplication.class);

	public static void main(String[] args) {
		// How we get the application context from the xml file we created and defined
		// our beans in
		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");) {

			/**
			 * This only shows the first bean in the applicationContext.xml file because
			 * only the first element of the array is passed.
			 * 
			 * LOGGER.info("Beans Loaded -> {}",
			 * applicationContext.getBeanDefinitionNames());
			 * 
			 * So to get the entire array we cast it to an Object
			 */
			LOGGER.info("Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());

			XMLPersonDao personDao = (XMLPersonDao) applicationContext.getBean(XMLPersonDao.class);
			System.out.println(personDao);
			System.out.println(personDao.getXMLJdbcConnection());

		}
	}

}
