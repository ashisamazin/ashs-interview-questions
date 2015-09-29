package com.ash.hackerrank;

public class Powers {

	public static void main(String[] args){
		Powers.bitShitForSumower(5);
		
		System.out.println(Powers.mathPower(5));
		
	}
	
	private static int mathPower(int i) {
		return (i*(i+1)*((2*i) + 1))/6;
	}

	public static void bitShitForSumower(int j){
		
		int x = 1;
		int y = 0;
		for (int i = 0; i < j; i++) {
			//bit shift 
			x = x<<1;
			y += x;
			System.out.println("x = " + x );
		}
		
		if( j == 0) System.out.println("The sum is 1"); 
		else { System.out.println("The sum is " + y);}
			
	}
}
