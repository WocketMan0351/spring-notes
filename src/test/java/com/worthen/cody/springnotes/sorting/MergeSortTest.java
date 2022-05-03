package com.worthen.cody.springnotes.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

	// Absence of failure is success

	@Test
	public void mergeSortWithInt() {
		Integer[] actual = { 17, 5, 18, 3, 9, 9, 99 };
		Integer[] expected = { 3, 5, 9, 9, 17, 18, 99 };

		MergeSort<Integer> mergeSort = new MergeSort<>();
		mergeSort.sort(actual, new DefaultComparator<Integer>());

		/**
		 * Asserts whether the expected and actual object arrays are deeply equal.
		 */
		assertArrayEquals(actual, expected);

		/**
		 * assertTrue(boolean condition)
		 * 
		 * --> Asserts whether the supplied condition is true
		 */
		assertTrue(Arrays.equals(actual, expected));
	}

	@Test
	public void mergeSortWithChar() {
		Character[] actual = { 'z', 'e', 'b', 'r', 'a' };
		Character[] expected = { 'a', 'b', 'e', 'r', 'z' };

		MergeSort<Character> mergeSort = new MergeSort<>();
		mergeSort.sort(actual, new DefaultComparator<Character>());

		/**
		 * Asserts whether the expected and actual object arrays are deeply equal.
		 */
		assertArrayEquals(actual, expected);
	}

}
