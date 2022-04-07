package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Finds an element in a range of a sorted array, using the binary search
 * algorithm. Returns the index where the element is found. Runs in O(log n)
 * time.
 */
@Component
public class BinarySearch<K> {

	private final SortAlgorithm<K> sortAlgorithm;

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
