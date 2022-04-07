package com.worthen.cody.springnotes;

import java.util.Arrays;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.worthen.cody.springnotes.sorting.BinarySearch;
import com.worthen.cody.springnotes.sorting.DefaultComparator;

@SpringBootApplication
public class SpringSortingApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringSortingApplication.class, args);

		// create unsorted array
		Integer[] numbers = new Integer[10];
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(10);
		}
		System.out.println("\n" + Arrays.toString(numbers));

		// binary search on unsorted array (must sort first)
		BinarySearch<Integer> binarySearch = (BinarySearch<Integer>) applicationContext.getBean("binarySearch");
		int index = binarySearch.binarySearch(numbers, 1, new DefaultComparator<Integer>());
		System.out.println("## Array sorted using " + binarySearch.getSortingAlgorithm());
		System.out.println("## BinarySearch found " + "1 at index " + index);
		System.out.println(Arrays.toString(numbers));

	}

}