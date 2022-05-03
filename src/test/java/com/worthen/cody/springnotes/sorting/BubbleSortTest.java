package com.worthen.cody.springnotes.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {

	@Test
	public void bubbleSortWithInt() {
		Integer[] actual = { 17, 5, 18, 3, 9, 9, 99 };
		Integer[] expected = { 3, 5, 9, 9, 17, 18, 99 };

		SortAlgorithm<Integer> bubbleSort = new QuickSort<>();
		bubbleSort.sort(actual, new DefaultComparator<>());

		assertArrayEquals(actual, expected);
	}

	@Test
	public void bubbleSortWithChar() {
		Character[] actual = { 'z', 'e', 'b', 'r', 'a' };
		Character[] expected = { 'a', 'b', 'e', 'r', 'z' };

		SortAlgorithm<Character> bubbleSort = new QuickSort<>();
		bubbleSort.sort(actual, new DefaultComparator<Character>());

		assertArrayEquals(actual, expected);
	}

}
