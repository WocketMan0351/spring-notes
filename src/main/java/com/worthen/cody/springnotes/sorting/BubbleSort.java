package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

import org.springframework.stereotype.Service;

/**
 * Sorts an array of size n in O(n^2) time, assuming two elements of the array
 * can be compared in O(1) time.
 */
@Service // business logic layer
public class BubbleSort<K> implements SortAlgorithm<K> {

	@Override
	public void sort(K[] array, Comparator<K> comp) {
		boolean sorted = false;
		K temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (comp.compare(array[i], array[i + 1]) > 0) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

}
