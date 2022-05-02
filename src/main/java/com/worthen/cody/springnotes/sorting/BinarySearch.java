package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Finds an element in a range of a sorted array, using the binary search
 * algorithm. Returns the index where the element is found. Runs in O(log n)
 * time.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // gives a new bean instance whenever requested
public class BinarySearch<K> {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * We are telling Spring that SortAlgorithm is a dependency (loosely coupled
	 * because we're using an interface and not a concrete implementation).
	 */
	private final SortAlgorithm<K> sortAlgorithm;

	/**
	 * By default, using @Qualifier("someClass") with the leading lowercase of a
	 * class tells spring to perform a component scan and find that corresponding
	 * Class (bean). @Autowired is OPTIONAL for constructor injection now.
	 */
	public BinarySearch(@Qualifier("mergeSort") SortAlgorithm<K> sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	/**
	 * Performs a binary search on an array of elements, depending on the given
	 * Comparator.
	 */
	public int binarySearch(K[] array, K elementToSearchFor, Comparator<K> comp) {
		return binarySearch(array, 0, array.length - 1, elementToSearchFor,
				new DefaultComparator<K>());
	}

	private int binarySearch(K[] array, int low, int high, K elementToSearchFor,
			Comparator<K> comp) {
		sortAlgorithm.sort(array, comp);

		if (low <= high) {
			int mid = (low + high) / 2;
			if (comp.compare(array[mid], elementToSearchFor) == 0) {
				return mid;
			} else if (comp.compare(array[mid], elementToSearchFor) < 0) {
				return binarySearch(array, mid + 1, high, elementToSearchFor, comp);
			} else {
				return binarySearch(array, low, mid - 1, elementToSearchFor, comp);
			}
		} else {
			return -1;
		}
	}

	public String getSortingAlgorithm() {
		return sortAlgorithm.getClass().toString();
	}

	@PostConstruct // called as soon as the bean is created and initialized w/ dependencies
	public void postConstruct() {
		logger.info("** postConstruct **");
	}

	/**
	 * called right before a bean is destroyed (used as a callback to signal a bean
	 * is being removed by the container)
	 * 
	 * @PreDestory DOES NOT WORK WHEN THE SCOPE OF THE BEAN IS PROTOTYPE BECAUSE THE
	 *             BEANS CREATED WITH THIS METHOD ARE NOT COMPLETELY MANAGED BY THE
	 *             IOC CONTAINER. IT WORKS WHEN THE SCOPE IS SINGLETON.
	 */
	@PreDestroy
	public void preDestroy() {
		logger.info("** preDestroy **");
		System.out.println(this.getClass().toString() + " has been destroyed");
	}

}
