package com.ash.random;


/**
 * This is the first basic implementation of the RandomGen question, which
 * involves looping over the numbers and probabilities every time we generate a
 * random number. This solution has a complexity of O(n) because of the fact we
 * loop over the input each time.
 */
public class RandomGenBasicImpl extends RandomGen {

	public RandomGenBasicImpl(int[] randomNums, double[] probabilities) {
		super(randomNums, probabilities);
	}

	@Override
	public int nextNum() {
		double randomNumber = random.nextDouble();
		double runningTotal = 0;
		for (int i = 0; i < probabilities.length; i++) {
			runningTotal += probabilities[i];
			if (randomNumber < runningTotal) {
				return randomNums[i];
			}
		}
		return randomNums[randomNums.length - 1];
	}
}