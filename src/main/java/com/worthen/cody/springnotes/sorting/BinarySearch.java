package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

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
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // gives a new bean instance whenever requested
public class BinarySearch<K> {

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
		return binarySearch(array, 0, array.length - 1, elementToSearchFor, new DefaultComparator<K>());
	}

	private int binarySearch(K[] array, int low, int high, K elementToSearchFor, Comparator<K> comp) {
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

}
