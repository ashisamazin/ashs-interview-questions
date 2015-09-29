package com.ash.hackerrank;

import java.util.Scanner;

public class AngryProf {

    public static void main(String[] args) {
		Scanner sc = new Scanner("2 4 3 -1 -3 4 2 4 2 0 -1 2 1");
		int numberOfClasses = sc.nextInt();

        for(int i = 0; i<numberOfClasses; i++){
            int numberOfStudents = sc.nextInt();
            int requiredOnTimeStudents = sc.nextInt();
            int[] studentTimes = new int[numberOfStudents];
            for(int j = 0; j < numberOfStudents; j++){
                studentTimes[j] = sc.nextInt();
            }
            
            checkClassTimes(requiredOnTimeStudents, studentTimes);
        }
    
    }
    
    /**
     * Method to calculate whether a class is cancelled or not
     */
    public static void checkClassTimes(int requiredOnTimeStudents, int[] studentTimes){
        int numberOfOnTimeStudents = 0;
        for(int studentTime : studentTimes){
            if(studentTime <= 0){
                numberOfOnTimeStudents++;
            }
        }
        
        if(numberOfOnTimeStudents >= requiredOnTimeStudents){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
	
}
