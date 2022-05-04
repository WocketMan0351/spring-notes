package com.worthen.cody.springnotes.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.worthen.cody.springnotes.SpringSortingApplication;

/**
 * UNIT TEST USING JAVA CONTEXT
 * 
 * We want to load the entire Spring context and grab the BinarySearch bean from
 * that context. (Since we're not using spring-boot-starter-test). Then,
 * 
 * 1) call the binarySearch()
 * 
 * 2) check if the value is correct
 */

// LOAD CONTEXT - this is where the context for BinarySearch bean is present:
@ContextConfiguration(classes = SpringSortingApplication.class)
// now that the context is provided, we run it (in JUnit 5):
@ExtendWith(SpringExtension.class)
public class BinarySearchTest {

	// get the bean from the context by autowiring it in
	@Autowired
	private BinarySearch<Integer> binarySearch;
	private DefaultComparator<Integer> comp = new DefaultComparator<Integer>();

	@Test
	public void testBasicScenario() {
		int index = binarySearch.binarySearch(new Integer[] { 3, 1, 2 }, 1, comp);

		// when sorted, array should be [1, 2, 3] putting 1 at index 0
		assertEquals(0, index);
	}

}
