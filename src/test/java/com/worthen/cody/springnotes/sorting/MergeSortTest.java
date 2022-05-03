package com.worthen.cody.springnotes.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

	// Absence of failure is success

	@BeforeAll // has to be a static method, run before all @Test
	public static void beforeAll() {
		System.out.println("BEFORE ALL");
	}

	@BeforeEach // run before each @Test
	public void beforeEach() {
		System.out.println("\nBEFORE EACH");
	}

	@AfterEach // run after each @Test
	public void afterEach() {
		System.out.println("AFTER EACH");
	}

	@AfterAll // has to be a static method, run after all @Test
	public static void afterAll() {
		System.out.println("\nAFTER ALL");
	}

	@Test // annotation that goes with each test you want to run
	public void mergeSortWithInt() {
		System.out.println("Running mergeSortWithInt()...");

		Integer[] actual = { 17, 5, 18, 3, 9, 9, 99 };
		Integer[] expected = { 3, 5, 9, 9, 17, 18, 99 };

		SortAlgorithm<Integer> mergeSort = new MergeSort<>();
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
		System.out.println("Running mergeSortWithChar()...");

		Character[] actual = { 'z', 'e', 'b', 'r', 'a' };
		Character[] expected = { 'a', 'b', 'e', 'r', 'z' };

		SortAlgorithm<Character> mergeSort = new MergeSort<>();
		mergeSort.sort(actual, new DefaultComparator<Character>());

		/**
		 * Asserts whether the expected and actual object arrays are deeply equal.
		 */
		assertArrayEquals(actual, expected);
	}

}
