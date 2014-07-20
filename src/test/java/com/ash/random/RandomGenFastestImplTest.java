package com.ash.random;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class RandomGenFastestImplTest {

	private RandomGenFastestImpl testObj;

	@Test
	public void testDistribution() {
		// setup
		int[] numbers = new int[] { -2, -1, 0, 1, 2 };
		double[] probabilities = new double[] { 0.01, 0.2, 0.58, 0.2, 0.01 };
		testObj = new RandomGenFastestImpl(numbers, probabilities);
		Map<Integer, Integer> numberToCount = new LinkedHashMap<Integer, Integer>();
		for (int i : numbers) {
			numberToCount.put(i, 0);
		}

		// run algo 100 times and map the distribution
		for (int i = 0; i < 100; i++) {
			int randomNumber = testObj.nextNum();
			int count = numberToCount.get(randomNumber);
			// re-add back to the map with incremented count
			numberToCount.put(randomNumber, ++count);
		}

		// print and assert the results
		for (Entry<Integer, Integer> entry : numberToCount.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		// Check 0 has the greatest probability
		assertTrue(numberToCount.get(0) > numberToCount.get(-2));
		assertTrue(numberToCount.get(0) > numberToCount.get(-1));
		assertTrue(numberToCount.get(0) > numberToCount.get(1));
		assertTrue(numberToCount.get(0) > numberToCount.get(2));

		// Then that -1 and 1 have greater probability than -2 and 2
		assertTrue(numberToCount.get(-1) > numberToCount.get(-2));
		assertTrue(numberToCount.get(-1) > numberToCount.get(2));
		assertTrue(numberToCount.get(1) > numberToCount.get(-2));
		assertTrue(numberToCount.get(1) > numberToCount.get(2));
	}

}