package com.ash.termcount;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Simple program which shows a simple algorithm for printing out the occurance
 * of search terms from a given set of strings.
 *
 */
public class MapsToStoreSearchTerms {

	private static Map<String, Integer> countOfSearchCities;

	static void OutputMostPopularDestination(int count, Scanner in) {
		countOfSearchCities = new HashMap<String, Integer>();

		// populate the map
		for (int i = 0; i < count; i++) {
			String city = in.next();
			if (!countOfSearchCities.containsKey(city)) {
				countOfSearchCities.put(city, 0);
			}
			countOfSearchCities.put(city, countOfSearchCities.get(city) + 1);
		}

		SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (Entry<String, Integer> entry : countOfSearchCities.entrySet()) {
			sortedMap.put(entry.getValue(), entry.getKey());
		}
		// Goes through the treemap now that it's in sorted order
		for (Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println("Term: " + entry.getValue() + " - Counter: " + entry.getKey());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner("6\n bar bar edi edi bar bar");
		int _count;
		_count = Integer.parseInt(in.nextLine());

		OutputMostPopularDestination(_count, in);

	}
}
