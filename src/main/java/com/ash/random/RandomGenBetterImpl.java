package com.ash.random;

import java.util.Arrays;
import java.util.Comparator;

/**
 * This implementation improves on the basic implementation by providing O(log
 * n) time for nextNum by sorting the accumulated probabilities and harnessing
 * the log n look up time for a sorted array.
 */
public class RandomGenBetterImpl extends RandomGen {

	private Interval[] accumulatedProbabilities;

	public RandomGenBetterImpl(int[] randomNums, double[] probabilities) {
		super(randomNums, probabilities);
		this.accumulatedProbabilities = new Interval[probabilities.length];
		double runningTotal = 0;
		for (int i = 0; i < probabilities.length; i++) {
			double newRunningTotal = runningTotal + probabilities[i];
			accumulatedProbabilities[i] = new Interval(runningTotal, newRunningTotal);
			runningTotal = newRunningTotal;
		}
	}

	@Override
	public int nextNum() {
		double randomNumber = random.nextDouble();
		Interval intervalToSearchFor = new Interval(randomNumber, randomNumber);
		int result = Arrays.binarySearch(accumulatedProbabilities, intervalToSearchFor, new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				if (o1.lowerBound < o2.lowerBound && o1.upperBound > o2.upperBound) {
					return 0;
				} else if (o1.lowerBound < o2.lowerBound) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		return randomNums[result];
	}

	private class Interval {
		private double lowerBound;
		private double upperBound;

		public Interval(double lowerBound, double upperBound) {
			super();
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}

		@Override
		public String toString() {
			return "Interval [lowerBound=" + lowerBound + ", upperBound=" + upperBound + "]";
		}

	}
}