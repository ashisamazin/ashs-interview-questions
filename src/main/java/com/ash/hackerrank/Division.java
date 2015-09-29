package com.ash.hackerrank;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfArgs = sc.nextInt();
		
		int positiveCounter = 0;
		int zeroCounter = 0;
		int negativeCounter = 0;
		for(int i =0; i<numberOfArgs; i++){
			int arg = sc.nextInt();
			if(arg < 0){
				negativeCounter++;
			}else if(arg> 0){
				positiveCounter++;
			}else{
				zeroCounter++;
			}
		}
		
		System.out.println(positiveCounter * 1.0d / numberOfArgs);
		System.out.println(negativeCounter * 1.0d/ numberOfArgs);
		System.out.println(zeroCounter * 1.0d/ numberOfArgs);

		
	}
}
