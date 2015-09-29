package com.ash.hackerrank;

import java.util.Scanner;

public class LibraryFine {

	public static void main(String[] args) {
		Scanner sc = new Scanner("12 12 1014 9 12 2015");
		int actualDay = sc.nextInt();
		int actualMonth = sc.nextInt();
		int actualYear = sc.nextInt();

		int expectedDay = sc.nextInt();
		int expectedMonth = sc.nextInt();
		int expectedYear = sc.nextInt();

		int lateFee = calculateLateFee(expectedDay, expectedMonth, expectedYear, actualDay, actualMonth, actualYear);
		System.out.println(lateFee);
	}

	private static int calculateLateFee(int expectedDay, int expectedMonth, int expectedYear, int actualDay, int actualMonth, int actualYear) {
		if (actualYear > expectedYear) {
			return 10000;
		} else if (actualYear < expectedYear) {
			return 0;
		} else {
			if (actualMonth > expectedMonth) {
				return 500 * (actualMonth - expectedMonth);
			} else if (actualMonth == expectedMonth && actualDay > expectedDay) {
				return 15 * (actualDay - expectedDay);
			} else {
				return 0;
			}
		}
	}
}
