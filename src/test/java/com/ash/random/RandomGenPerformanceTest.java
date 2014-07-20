package com.ash.random;

import org.junit.Test;

public class RandomGenPerformanceTest {

	private RandomGen impl1;
	private RandomGen impl2;

	@Test
	public void testDistribution() {
		int[] randomNums = new int[100000];
		double[] probabilities = new double[100000];

		for (int i = 0; i < randomNums.length; i++) {
			randomNums[i] = i;
			probabilities[i] = 0.00001;
		}
		impl1 = new RandomGenBasicImpl(randomNums, probabilities);
		impl2 = new RandomGenBetterImpl(randomNums, probabilities);

		long a1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			impl1.nextNum();
		}
		long b1 = System.currentTimeMillis();

		long a2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			impl2.nextNum();
		}
		long b2 = System.currentTimeMillis();

		System.out.println("Time taken for basic impl: " + (b1 - a1));
		System.out.println("Time taken for better impl: " + (b2 - a2));

	}

}