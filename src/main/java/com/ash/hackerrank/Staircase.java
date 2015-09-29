package com.ash.hackerrank;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		for (int i = 0; i < height; i++) {
			char[] line = new char[height];
			for (int j = 0; j < height - i - 1; j++) {
				line[j] = ' ';
			}
			for (int j = height - i - 1; j < height; j++) {
				line[j] = '#';
			}
			System.out.println(line);
		}
	}
}
