/* Name: Jimmy O'Hara
 * Class: CS1450 (T/TH) 
 * Due: 1/26/23
 * Assignment: #1
 * Purpose: To get used to java coding again and getting
 *  back in the swing of using arrays and loops
 */

public class OHaraJimmyAssignment1 {

	public static void main(String[] args) {
		
		//declaring constants 
		final int MINIMUM = 10;
		final int MAXIMUM = 31;
		
		
		//Task #1 | Create a array of random integers
		//allocating memory for the array
		int[] randArray = new int[20];
		
		//putting random numbers into array
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = MINIMUM + (int)(Math.random()*MAXIMUM);
		}
		
		//displaying the array
		for (int i = 0; i < randArray.length; i++) {
			System.out.println("randArray[" + i + "] = " + randArray[i]);
		}
		
		//task #2 | Sum, Average, and Median, and Largest Num
		
		//Sum
		int sum = sum(randArray);
		
		//Average
		double average = average(sum, randArray.length);
		
		//Median
		for (int i = 0; i < randArray.length; i++) {
			
		}
		
		//Largest Value
		for (int i = 0; i < randArray.length; i++) {
			
		}
		
		
	}//main

	//Method for finding the sum of all items in an array
	public static int sum(int[] array) {
		
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
		
	}//sum
	
	//Method for finding the average value of an array
	public static double average(int sum, int length) {
		
		double tempSum = sum;
		double tempLength = length;
		
		
		double average = tempSum / tempLength;
		return average;
		
	}//average
	
	//method for finding the median in an array
	
	public static int median() { //figure out what to put here
		//changes again
	}
	
	
}//Assignment 1

//classes would go here (after assignment#)


