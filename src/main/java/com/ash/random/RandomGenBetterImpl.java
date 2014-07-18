package com.ash.random;

import java.util.Arrays;


/**
 * This implementation improves on the basic implementation by
 * providing O(log n) time for nextNum by sorting the accumulated probabilities
 * and harnessing the log n look up time for a sorted array.
 */
public class RandomGenBetterImpl extends RandomGen {

	private double[] accumulatedProbabilities;
	
	public RandomGenBetterImpl(int[] randomNums, double[] probabilities) {
		super(randomNums, probabilities);
		this.accumulatedProbabilities = new double[probabilities.length];
		double runningTotal = 0;
		for (int i = 0; i < probabilities.length; i++) {
			runningTotal += probabilities[i];
			accumulatedProbabilities[i] = runningTotal;
		}
	}

	@Override
	public int nextNum() {
		double randomNumber = random.nextDouble();
		int result = Arrays.binarySearch(accumulatedProbabilities, randomNumber);
		return result;
	}
}