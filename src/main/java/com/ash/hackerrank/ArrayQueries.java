package com.ash.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfArrayElements = sc.nextInt();
		int numberOfQueries = sc.nextInt();

		Integer[] array = new Integer[numberOfArrayElements];
		for (int i = 0; i < numberOfArrayElements; i++) {
			array[i] = sc.nextInt();
		}

		for (int i = 0; i < numberOfQueries; i++) {
			int queryType = sc.nextInt();
			int startIndex = sc.nextInt();
			int endIndex = sc.nextInt();

			array = computeArray(array, queryType, startIndex-1, endIndex);
		}
		System.out.println(array[0] - array[array.length - 1]);
		String arrayPrint = Arrays.toString(array).replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println(arrayPrint);
	}

	private static Integer[] computeArray(Integer[] array, int queryType, int startIndex, int endIndex) {
		Integer[] slicedSection = new Integer[endIndex - startIndex];
		System.arraycopy(array, startIndex, slicedSection, 0, endIndex - startIndex);

		Integer[] front = new Integer[startIndex];
		System.arraycopy(array, 0, front, 0, startIndex);

		Integer[] back = new Integer[array.length - endIndex];
		System.arraycopy(array, endIndex, back, 0, array.length - endIndex);

		List<Integer> result = new ArrayList<Integer>();
		if (queryType == 1) {
			result.addAll(Arrays.asList(slicedSection));
			result.addAll(Arrays.asList(front));
			result.addAll(Arrays.asList(back));
		} else if (queryType == 2) {
			result.addAll(Arrays.asList(front));
			result.addAll(Arrays.asList(back));
			result.addAll(Arrays.asList(slicedSection));
		}

		return result.toArray(new Integer[array.length]);
	}
}
