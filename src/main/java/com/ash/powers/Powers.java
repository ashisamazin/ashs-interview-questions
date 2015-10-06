package com.ash.powers;

/**
 * Simple class to show using bitwise operations to calculating sums of powers
 * of 2
 */
public class Powers {

	public static void main(String[] args) {
		System.out.println(sumPowersOfTwo(1));// 2^2
		System.out.println(sumPowersOfTwo(2));// 2^2
		System.out.println(sumPowersOfTwo(3));// 2^3
		System.out.println(sumPowersOfTwo(4));// 2^4
		System.out.println(sumPowersOfTwo(5));// 2^5
	}

	// Returns sum of powers of two - e.g. 2^3 + 2^2 + 2^1
	public static int sumPowersOfTwo(int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += 2 << i;
		}
		return sum;
	}
}
