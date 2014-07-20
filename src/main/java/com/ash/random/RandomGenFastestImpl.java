package com.ash.random;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RandomGenFastestImpl extends RandomGen {

	private List<Integer> numbers;

	public RandomGenFastestImpl(int[] randomNums, double[] probabilities) {
		super(randomNums, probabilities);
		int maxDecimalPlaces = 0;
		for (int i = 0; i < probabilities.length; i++) {
			String text = Double.toString(Math.abs(probabilities[i]));
			maxDecimalPlaces = Math.max(text.length() - text.indexOf('.') - 1, maxDecimalPlaces);
		}
		for (int i = 0; i < probabilities.length; i++) {
			probabilities[i] = BigDecimal.valueOf(probabilities[i]).multiply(BigDecimal.TEN.pow(maxDecimalPlaces)).doubleValue();
		}
		numbers = new ArrayList<Integer>();
		for (int i = 0; i < randomNums.length; i++) {
			int number = randomNums[i];
			for (int j = 0; j < probabilities[i]; j++) {
				numbers.add(number);
			}
		}
	}

	@Override
	public int nextNum() {
		return numbers.get(random.nextInt(numbers.size()));
	}

}