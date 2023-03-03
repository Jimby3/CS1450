/* Name: Jimmy O'Hara
 * Class: CS1450 (T/TH) 
 * Due: 3/3/23
 * Assignment: #5
 * Purpose: to use stacks and generic methods in order to manipulate data
 */

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Stack;
import java.util.Scanner;

public class OHaraJimmyAssignment5 {

	public static void main(String[] args) throws IOException {

		// 						\\
		// Part 1 \\
		//						 \\

		// initialize values
		int[] numbers = { 7, 2, 4, 3, 5, 1, 6, 8, 9 };

		// Creating JCF Stack
		Stack<Integer> stack1 = new Stack<>();

		// putting values into stack
		for (int i = 0; i < numbers.length; i++) {
			stack1.push(numbers[i]);
		}

		// Calling remove odd values method on stack
		removeOddValues(stack1);

		printStack(stack1);
		//						 \\
		// Part 2 \\
		// 						\\


		Scanner userInput = new Scanner(System.in);
		
		//----------------------
		// Numbers Stack
		//----------------------
		
		// Reading from file(s) and making scanner(s)
		File intFileName = new File("Numbers.txt");
		Scanner intFile = new Scanner((intFileName));
		
		GenericStack<Integer> stack2 = new GenericStack<>();
		
		// bool flag
		boolean hasNext = intFile.hasNext();
		
		// iterating through file
		while (hasNext) {

			// adding values to generic stack
			stack2.push(intFile.nextInt());

			// bool flag
			hasNext = intFile.hasNext();
		} // while hasNext
		
		System.out.println("Values from file that are pushed onto number stack.");
		System.out.println("--------------------------------------\n");
		printStack(stack2);

		sortStack(stack2);
		
		
		System.out.println("Number Stack sorted - smallest to highest: ");
		System.out.println("--------------------------------------\n");
		printStack(stack2);
		
		System.out.println("\n What would you like to move to the bottle of the stack?");
		
		int intInput = userInput.nextInt();
		
		while (!moveToBottom(stack2, intInput)) {
			System.out.println("Value " + intInput + " is not on the stack. Please try again");
			intInput = userInput.nextInt();
		}
		
		System.out.println("\n\nString Stack - move " + intInput + " to the bottom");
		System.out.println("--------------------------------------\n");
		printStack(stack2);
		
		
		
		
		intFile.close();
		
		//-----------------
		//String Stack
		//--------------
		
		File stringFileName = new File("Strings.txt");
		Scanner stringFile = new Scanner((stringFileName));
		
		GenericStack<String> stack3 = new GenericStack<>();
		
		while (stringFile.hasNext()) {
			
			stack3.push(stringFile.next().trim());
			
		}//while
		
		System.out.println("Values from file that are pushed onto number stack.");
		System.out.println("--------------------------------------\n");
		printStack(stack3);

		sortStack(stack3);
		
		System.out.println("String Stack sorted - Alphabetical Order: ");
		System.out.println("--------------------------------------\n");
		printStack(stack3);

		System.out.println("\n What would you like to move to the bottle of the stack?");
		
		String stringInput = userInput.next();
		
		while (!moveToBottom(stack3, stringInput)) {
			System.out.println("Value " + stringInput + " is not on the stack. Please try again");
			stringInput = userInput.next();
		}
		
		System.out.println("\n\nString Stack - move " + stringInput + " to the bottom");
		System.out.println("--------------------------------------\n");
		printStack(stack3);
		
		
		stringFile.close();
		userInput.close();
		
	}// main

	//					 \\
	// Part 1 Methods \\
	// 					\\

	// remove odd values method
	public static void removeOddValues(Stack<Integer> stack) {

		// creating temp stack
		Stack<Integer> tempStack = new Stack<>();

		// Boolean flag
		boolean isEmpty = stack.isEmpty();

		// iterating while the OG stack is not empty
		while (isEmpty != true) {

			int value = stack.peek();

			if (value % 2 == 0) {

				tempStack.push(value);

			} // if

			// removing item from the stack
			stack.pop();

			// bool flag to check if not empty
			isEmpty = stack.isEmpty();

		} // while

		isEmpty = tempStack.isEmpty();
		// adding things from temp stack back to main stack, in same order since of LIFO
		while (isEmpty != true) {

			int value = tempStack.peek();

			// pushing value from tempArray back into main array, then allowing the next
			// number to be access
			stack.push(value);
			tempStack.pop();

			// bool flag checker
			isEmpty = tempStack.isEmpty();

		} // while

	}// remove odd values

	public static void printStack(Stack<Integer> stack) {

		// creating temp stack
		Stack<Integer> tempStack = new Stack<>();

		System.out.println("Stack After Odd Values Are Removed");
		System.out.println("--------------------------------------\n");

		// Boolean flag
		boolean isEmpty = stack.isEmpty();

		// iterating while the OG stack is not empty
		while (isEmpty != true) {

			int value = stack.peek();

			System.out.println(value);

			// puting numbers on temp stack so I can put them back in OG stack after popping
			tempStack.push(value);

			// removing item from the stack
			stack.pop();

			// bool flag to check if not empty
			isEmpty = stack.isEmpty();

		} // while

		// boolean flag
		isEmpty = tempStack.isEmpty();

		// adding things from temp stack back to main stack, in same order because of
		// LIFO
		while (isEmpty != true) {

			int value = tempStack.peek();

			// pushing value from tempArray back into main array, then allowing the next
			// number to be access
			stack.push(value);
			tempStack.pop();

			// bool flag checker
			isEmpty = tempStack.isEmpty();

		} // while

		System.out.println("\n");

	}// printStack

//								 \\
//      Part 2 Methods           \\
// 								 \\

	// Print Stack Generic Method
	public static <E> void printStack(GenericStack<E> stack) {

		// creating temp stack
		Stack<E> tempStack = new Stack<>();

		// Boolean flag
		boolean isEmpty = stack.isEmpty();

		// iterating while the OG stack is not empty
		while (isEmpty != true) {

			E value = stack.peek();

			System.out.println(value);

			// puting numbers on temp stack so I can put them back in OG stack after popping
			tempStack.push(value);

			// removing item from the stack
			stack.pop();

			// bool flag to check if not empty
			isEmpty = stack.isEmpty();

		} // while

		// boolean flag
		isEmpty = tempStack.isEmpty();

		// adding things from temp stack back to main stack, in same order because of
		// LIFO
		while (isEmpty != true) {

			E value = tempStack.peek();

			// pushing value from tempArray back into main array, then allowing the next
			// number to be access
			stack.push(value);
			tempStack.pop();

			// bool flag checker
			isEmpty = tempStack.isEmpty();

		} // while

		System.out.println("\n");

	}// print stack

	// Sort Stack method
	public static <E extends Comparable<E>> void sortStack(GenericStack<E> stack) {

		GenericStack<E> tempStack = new GenericStack<>();
		
		while (stack.isEmpty() != true) {
		E smallest = removeSmallest(stack);
		
		tempStack.push(smallest);
		
		}//while
		
		//putting values back on og array
		boolean isEmpty = false;
		
		while (tempStack.isEmpty() != true) {
			
			E value = tempStack.peek();
			
			stack.push(value);
			
			tempStack.pop();
			
			}//while
		
		
	}// sortStack

	// Remove smallest method
	public static <E extends Comparable<E>> E removeSmallest(GenericStack<E> stack) {

		// temp stack
		GenericStack<E> tempStack = new GenericStack<>();

		// Return var setting equal to first num in stack a
		E smallest = stack.peek();

		// iterating through stack with while and bool flag
		boolean isEmpty = false;

		while (isEmpty != true) {

			E value = stack.peek();

			tempStack.push(value);

			stack.pop();

			if (value.compareTo(smallest) == -1) {

				smallest = value;

			} // if

			isEmpty = stack.isEmpty();
		} // while

		// boolean flag
		isEmpty = false;

		// loop to put values back in OG array
		while (isEmpty != true) {

			E value = tempStack.peek();

			tempStack.pop();

			if (value != smallest) {

				stack.push(value);

			} // if

			isEmpty = tempStack.isEmpty();
		} // while

		return smallest;
	}// removeSmallest

	//Move to bottom method
	public static <E> boolean moveToBottom(GenericStack<E> stack, E valueToMove) {
		
		//return Variable to test that it was able to move variable to bottom
		boolean success = false;
		
		//holding given value so that it can be at bottom of stack
		E holding = null;
		
		// temp stack
		GenericStack<E> tempStack = new GenericStack<>();
		
		while (stack.isEmpty() != true) {
			
			E value = stack.peek();
			
			stack.pop();
			
			
			
			//if the value is found while going through stack, return true
			if (value.equals(valueToMove)) {
				success = true;
				holding = value;
				
			} else {
				
				tempStack.push(value);
				
			}//else
			
			
		}//while
		
		if (success) {
			stack.push(holding);
		}//if
		
		while (tempStack.isEmpty() != true) {
			
			E value = tempStack.peek();
			
			tempStack.pop();
			
			stack.push(value);
		}
	
		return success;
	}//moveToBottom

	
	
	
	
} // OHaraJimmyAssignment5



//=========
// Classes
//=========


class GenericStack<E> {

	private ArrayList<E> list = new ArrayList<>();

	// Default Constructor
	public GenericStack() {

	}// constructor

	// isEmpty Method
	public boolean isEmpty() {

		boolean value = false;

		value = list.isEmpty();

		return value;
	}// isEmpty

	// getSize method
	public int getSize() {

		return list.size();

	}// getSize

	// peek method
	public E peek() {
		E peekValue = list.get(getSize() - 1);
		return peekValue;

	}// peek

	// pop method
	public E pop() {
		// (why does pop return a value in the class?)
		E popValue = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return popValue;

	}// pop

	// push method
	public void push(E value) {
		list.add(value);
	}// push

}// GenericStack
