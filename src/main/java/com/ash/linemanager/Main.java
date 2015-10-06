package com.ash.linemanager;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner("5\nSarah Claudiu June Sarah Sarah Tom Tom Simon Tom Claudiu");
		outputCommonManager(in);

		in = new Scanner("6\nHilary James Sarah Fred Sarah Paul Fred Hilary Fred Jenny Jenny James");
		outputCommonManager(in);
	}

	public static void outputCommonManager(Scanner in) {
		int count = Integer.parseInt(in.nextLine());
		String firstEmployee = in.next();
		String secondEmployee = in.next();

		// internal binary tree structure to store the employees
		Company company = new Company();
		for (int i = 0; i < count - 1; i++) {
			company.addManagerAndEmployee(in.next(), in.next());
		}
		System.out.println("****** Company Structure ******");
		System.out.println(company);

		System.out.println("****** Common manager between " + firstEmployee + " and " + secondEmployee + " ******");
		System.out.println(company.getCommonManager(firstEmployee, secondEmployee));
	}

}
