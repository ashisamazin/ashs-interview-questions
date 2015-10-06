package com.ash.fibonacci;

public class FibIterative {

	public static void main(String[] args) {

		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));

	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int first = 0;
		int second = 1;
		int third = 0;
		for (int i = 1; i < n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}
}
