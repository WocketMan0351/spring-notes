package com.worthen.cody.springnotes.cdi;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Annotation for CDI - Container Dependency Injection, like an interface which
 * Spring is an implementation of.
 * 
 * CDI is a Java EE standard (i.e. instead of using Hibernate (which is an
 * implementation of JPA), you would use JPA.
 */
@Named
public class SomeCdiBusiness {

	/**
	 * Annotation for CDI - Container Dependency Injection, like an interface which
	 * Spring implements.
	 */
	@Inject
	SomeCdiDao someCdiDao;

	public SomeCdiDao getSomeCdiDao() {
		return someCdiDao;
	}

	public void setSomeCdiDao(SomeCdiDao someCdiDao) {
		this.someCdiDao = someCdiDao;
	}

	public int findMax() {
		int[] data = someCdiDao.getData();

		int max = Integer.MIN_VALUE;
		for (int i : data) {
			if (i > max) {
				max = i;
			}
		}

		return max;
	}

}
