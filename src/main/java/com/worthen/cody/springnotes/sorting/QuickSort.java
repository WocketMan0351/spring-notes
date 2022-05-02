package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

import org.springframework.stereotype.Service;

/**
 * Sorts an array of size n with an expected running time of O(n log n) and
 * worst-case running time of O(n^2), assuming two elements of the array can be
 * compared in O(1) time.
 */
@Service // business logic layer
public class QuickSort<K> implements SortAlgorithm<K> {

	@Override
	public void sort(K[] array, Comparator<K> comp) {
		quickSortInPlace(array, comp, 0, array.length - 1);
	}

	/**
	 * Sorts the subarray S[a...b], inclusive, in-place.
	 */
	public void quickSortInPlace(K[] S, Comparator<K> comp, int a, int b) {
		if (a >= b) {
			return; // subarray is already sorted
		}
		int left = a;
		int right = b - 1;
		K pivot = S[b]; // pivot is last element
		K temp; // temp object used for swapping
		while (left <= right) {
			// scan until reaching value equal to or larger than the pivot (or right marker)
			while (left <= right && comp.compare(S[left], pivot) < 0) {
				left++;
			}
			// scan until reaching value equal to or smaller than the pivot (or left marker)
			while (left <= right && comp.compare(S[right], pivot) > 0) {
				right--;
			}
			if (left <= right) { // indices did not strictly cross
				// swap values and shrink range
				temp = S[left];
				S[left] = S[right];
				S[right] = temp;
				left++;
				right--;
			}
		}
		// put pivot into its final place (currently marked by left index)
		temp = S[left];
		S[left] = S[b];
		S[b] = temp;
		// make recursive calls
		quickSortInPlace(S, comp, a, left - 1);
		quickSortInPlace(S, comp, left + 1, b);
	}

}