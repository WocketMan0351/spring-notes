package com.worthen.cody.springnotes.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class DefaultComparatorTest {

	@Test
	public void compareInt() {
		Comparator<Integer> comp = new DefaultComparator<>();
		assertTrue(comp.compare(5, 5) == 0);
	}

	@Test
	public void compareChar() {
		Comparator<Character> comp = new DefaultComparator<>();
		assertTrue(comp.compare('a', 'a') == 0);
	}

}
