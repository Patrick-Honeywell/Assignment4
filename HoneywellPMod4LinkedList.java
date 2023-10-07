import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Class that inserts user input integers into a sorted Linked List.
 * @author Patrick Honeywell
 * @version 1.0.0
 * @since Week 4 of Class 6301
 */
public class HoneywellPMod4LinkedList {
	
	
	/**
	 * Main method of the class
	 * Initializes a scanner named "sc".
	 * Initializes a LinkedList from collections called "inputNumbersList".
	 * Uses a while statement to ask for an integer input that is added to the list sorted from least to greatest.
	 * After each integer input it prints the list.
	 * After non-integer input it ends the program and prints the sorted list.
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> inputNumbersList = new LinkedList<>();

        // Read input integers until a non-integer
        while (true) {
            System.out.print("Input an integer (non-integer to end): ");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                /**
                 *  Insert integer into sorted LinkedList
                 */
                insertSorted(inputNumbersList, number);
                
                // Print the sorted LinkedList after each addition
                System.out.println("Sorted List: " + inputNumbersList);
            } else {
            	System.out.print("Final List: " + inputNumbersList);
                break; // Exit when non-integer is entered
            }
        }

        sc.close();
    }

    /**
     * Method to insert integer into a sorted LinkedList
     * @param inputNummberslist = Linked List
     * @param number = input from the scanner
     */
    private static void insertSorted(LinkedList<Integer> inputNumberslist, int number) {
        ListIterator<Integer> it = inputNumberslist.listIterator();
        while (it.hasNext()) {
            int next = it.next();
            if (number < next) {
                it.previous();
                it.add(number);
                return;
            }
        }
        // If integer is greater than all values in Linked List, insert at end
        inputNumberslist.add(number);
    }
}
