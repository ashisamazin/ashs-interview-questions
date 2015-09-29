package com.ash.linemanager;

import java.util.Scanner;

//Example: 
//
//Input: 
//6 
//Jon Mark 
//Jon David 
//Mark Paul 
//Paul Lee 
//Paul Steve 
//
//Output: 
//Jon 
//Mark David 
//Paul 
//Lee Steve 
//
//Input: 
//7 
//Jon Lee 
//Lee Paul 
//Paul Mark 
//Paul David 
//Lee Steve 
//Steve Mat 
//
//Output: 
//Jon 
//Lee 
//Paul Steve 
//Mark David Mat

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner("7 Jon Lee Lee Paul Paul Mark Paul David Lee Steve Steve Mat");
		//Scanner sc = new Scanner("6 Jon Mark Jon David Mark Paul Paul Lee Paul Steve");

		int numberOfArgs = sc.nextInt();
		
		//internal binary tree to store employees and their managers
		Company company = new Company();
		for(int i =0; i<numberOfArgs-1; i++){
			company.addManager(sc.next(), sc.next());
		}
		
		company.printCompany();
		
	}


	
}
