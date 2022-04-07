package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

public interface SortAlgorithm<K> {

	/**
	 * Sorts an array of elements according to the given Comparator.
	 * 
	 * @param array an array of elements
	 * @param comp  a Comparator
	 */
	public void sort(K[] array, Comparator<K> comp);

}
