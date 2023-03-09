// CS1450 Assignment #6 Spring 2023
// Worksheet #2: Simple Nested Objects (Queues: not nested in a class and nested in a class)
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

import java.util.LinkedList;
import java.util.Queue;

public class Worksheet2_Spring2023 {

	public static void main(String[] args) {
		
		//*******************************************
		// Worksheet2 Question #1 
		// Queue in main - queue is NOT nested inside a class
		// Practice creating a queue and adding the values 8,17,4,52
		//*******************************************
		// ADD CODE HERE
		// Name the queue -> queueNotNested

		Queue<Integer> queueNotNested = new LinkedList<>();
		queueNotNested.offer(8);
		queueNotNested.offer(17);
		queueNotNested.offer(4);
		queueNotNested.offer(52);
		
		
		
		
		// Test your queue that is not nested in a class by displaying the values in the queue
		System.out.println("Values in a queue that is not nested in a class");
		int queueLength = queueNotNested.size();
		for (int i = 0; i < queueLength; i++) {
			System.out.println("aQueue[" + i + "] = " + queueNotNested.remove());
		}

		//********************************
		// Worksheet2 Question #2
		// See NumberQueue Class below
		//********************************

		
		//********************************
		// Worksheet2 Question #3a 
		// Use this code to test your NumberQueue class.
		// The queue is now nested inside a class called NumberQueue.
		// Create an object of type NumberQueue and add the values 8, 17, 4, 52
		//********************************
		// ADD CODE HERE

		NumberQueueW2 nestedQueue = new NumberQueueW2();
		nestedQueue.offer(8);
		nestedQueue.offer(17);
		nestedQueue.offer(4);
		nestedQueue.offer(52);
		
	
		
		//********************************
		// Worksheet2 Question #3b
		// Test your nested queue by displaying the values in the queue
		//********************************
		// ADD CODE HERE		
		System.out.println();
		System.out.println("Values in a queue nested in a class");

		
		int sizeBefore = nestedQueue.size();
		for (int i = 0; i < sizeBefore; i++) {
			System.out.print(nestedQueue.remove() + "\n");
		}
		
		
		

	} // main

} // Worksheet2


//****************************************************
// Worksheet2 Question #2
// This class "contains" a queue of integers. (HAS-A relationship)
// The class will provide methods to access the queue which it contains.
// Write the code for each method.
//****************************************************
class NumberQueueW2 {
	
	private Queue<Integer> aQueue = new LinkedList<>();

	public int size() {
		// ADD CODE HERE
		return aQueue.size();
		
	}
	
	public void offer(Integer value) {
		// ADD CODE HERE
		aQueue.offer(value);
		
	}
	
	public Integer remove() {
		// ADD CODE HERE
		return aQueue.remove();
		
	}
	
} // NumberQueueW2
