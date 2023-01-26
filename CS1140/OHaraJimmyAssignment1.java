import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

/* Name: Jimmy O'Hara
 * Class: CS1450 (T/TH) 
 * Due: 1/26/23
 * Assignment: #1
 * Purpose: To get used to java coding again and getting
 *  back in the swing of using arrays and loops
 */

public class OHaraJimmyAssignment1 {

	public static void main(String[] args) throws IOException {

		// declaring constants
		final int MINIMUM = 10;
		final int MAXIMUM = 31;

		// Task #1 | Create a array of random integers
		// allocating memory for the array
		int[] randArray = new int[20];

		// putting random numbers into array
		for (int i = 0; i < randArray.length; i++) {
			randArray[i] = MINIMUM + (int) (Math.random() * MAXIMUM);
			System.out.println(randArray[i]);
		}


		// task #2 | Sum, Average, and Median, and Largest Num

		// Sum
		int sum = sum(randArray);
		System.out.println("\n\nSum: " + sum);

		// Average
		double average = average(sum, randArray.length);
		System.out.println("Average: " + average);

		// Median
		Arrays.sort(randArray);
		
		int medianIndex = median(randArray);
		
		System.out.println("Median: " + randArray[medianIndex]);

		
		// Largest Value
		int largestValue = largestValue(randArray);
		int largestCounter = largestFrequency(randArray, largestValue);
		
		System.out.println("Largest Value: " + largestValue + " which displayed " + largestCounter + " time(s)");
		
		
		//Task #3 | 2D array
		
		//Declaring Constants
		final int ROWS = 4;
		final int COLUMNS = 5;
		
		
		//Creating the 2D array
		int[][] array2D = new int[ROWS][COLUMNS];
		
		
		//Counter for orignal array
		int randArrayIndex = 0;
		
		//row for loop
		for (int i = 0; i < ROWS ; i++) {
			
			System.out.println("\n");
			
			//column for loop
			for (int j = 0; j < COLUMNS; j++) {
				
				array2D[i][j] = randArray[randArrayIndex];
				
				randArrayIndex++;
				
				System.out.print(array2D[i][j] + " ");
				
			}//column
			
		}//row

		//Task #4 | Printing to a file
		
		File fileName = new File("assignment1.txt");
		
		PrintWriter outputFile = new PrintWriter(fileName);
		
		//counter for randArray
		randArrayIndex = 0;
		
		//row for loop
		for (int i = 0; i < ROWS ; i++) {
			
			outputFile.print("\n");
			
			//column for loop
			for (int j = 0; j < COLUMNS; j++) {
				
				array2D[i][j] = randArray[randArrayIndex];
				
				randArrayIndex++;
				
				outputFile.print(array2D[i][j] + " ");

			}//column
			
		}//row
		
		outputFile.close();
		
		
		//reading/printing from the file
		
		Scanner fileInput = new Scanner(fileName);
		
		System.out.println("\n\n");
		
		//reading from the file
		for (int i = 0; i < randArray.length; i++) {
			int num = fileInput.nextInt();
			System.out.println(num);
		}
		
		
		
		System.out.println("\n\nFile is in directory: " + fileName.getAbsolutePath());
		
		
	}// main

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("randArray[" + i + "] = " + array[i]);
		}
	}

	// Method for finding the sum of all items in an array
	public static int sum(int[] array) {

		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum;

	}// sum

	// Method for finding the average value of an array
	public static double average(int sum, int length) {

		double tempSum = sum;
		double tempLength = length;

		double average = tempSum / tempLength;
		return average;

	}// average

	// method for finding the median in an array
	public static int median(int[] array) { // figure out what to put here
		
		double medianIndex = 0;
		
		medianIndex = (array.length / 2) - 1;
		int indexReal = (int)Math.round(medianIndex);

		return indexReal;
	}//median
	
	//Finding largest number in largest array
	public static int largestValue(int[] sortedArray) {
		
		int largestIndex = sortedArray.length -1;
		int largest = sortedArray[largestIndex];
		
		return largest;
	}
	
	//Finding how many times the largest number happens in an array
	public static int largestFrequency(int[] array, int largest) {
		
		int frequency = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == largest) {
				frequency++;
			}
		}
		
		return frequency;
	}

}// Assignment 1

//classes would go here (after assignment#)
