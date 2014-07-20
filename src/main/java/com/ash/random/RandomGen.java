package com.ash.random;

import java.math.BigDecimal;
import java.util.Random;

/**
 * This interview question was given to me by a hedge fund and involved
 * implementing the nextNum() method, which should return a random number with
 * the weightings specified in the constructor.
 * 
 */
public abstract class RandomGen {

	// Values that may be returned by nextNum()
	protected final int[] randomNums;
	// Probability of the occurence of randomNums
	protected final double[] probabilities;
	//the random utility used to generate random numbers
	protected final Random random;
	
	public RandomGen(int[] randomNums, double[] probabilities) {
		this.randomNums = randomNums;
		this.probabilities = probabilities;
		this.random = new Random();
		// Validate the input
		if (randomNums == null || probabilities == null || randomNums.length != probabilities.length) {
			throw new IllegalArgumentException("Both random number and probability arrays must be of equal length!");
		}
		BigDecimal runningTotal = BigDecimal.ZERO;
		for (int i = 0; i < probabilities.length; i++) {
			runningTotal = runningTotal.add(BigDecimal.valueOf(probabilities[i]));
		}
		if (runningTotal.doubleValue() != 1d) {
			throw new IllegalArgumentException("Probabilities must add up to 1!");
		}
	}
	
	/**
	 * Returns one of the randomNums. When this method is called multiple times
	 * over a long period, it should return the numbers roughly with the
	 * initialized probabilities.
	 */
	public abstract int nextNum();
}
