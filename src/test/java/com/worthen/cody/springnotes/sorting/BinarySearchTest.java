package com.worthen.cody.springnotes.sorting;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	BinarySearch<Integer> binarySearch;

	Integer[] array = { 4, 7, 1, 6 };
	Comparator<Integer> comp = new DefaultComparator<Integer>();

	@BeforeEach
	void setUp() {
		binarySearch = new BinarySearch<>(new MergeSort<Integer>());
	}

	@Test
	void binarySearch() {
		System.out.println("array sorted, 1 is at index " + binarySearch.binarySearch(array, 1, comp));
		System.out.println(binarySearch.getSortingAlgorithm());
	}

}
