package com.ash.random;


/**
 * This is the most complex solution, but it provides constant O(1) run time for
 * the nextNum() function by using a hash algorithm.
 */
public class RandomGenHashingImpl extends RandomGen {

	public RandomGenHashingImpl(int[] randomNums, double[] probabilities) {
		super(randomNums, probabilities);
	}

	@Override
	public int nextNum() {
		//TODO implement
		return 0;
	}
}