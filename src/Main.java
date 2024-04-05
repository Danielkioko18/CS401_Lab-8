/*
Main class to run all thje programs in this app 
*/
//Import needed libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//The mai class
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        /*
        display options to the user for choice
        */
        System.out.println("Choose an option:\n");
        System.out.println("1) SortedLinkedList");
        System.out.println("2) CircularLinkedList");
        System.out.println("3) DoublyLinkedList");
        
        System.out.println("Enter Your Choice(1,2 or 3): ");

        try {
            // Prompt to read users choice
            int choice = Integer.parseInt(reader.readLine());

            // Execution based on the choice
            switch (choice) {
                case 1:
                    // Run CircularLinkedList
                    System.out.println("Running SortedLinkedList...");
                    SortedLinkedList.main(args);
                    break;
                case 2:
                    // Run CircularLinkedList
                    System.out.println("Running CircularLinkedList...");
                    CircularLinkedList.main(args);
                    break;
                case 3:
                    // Run DoublyLinkedList
                    System.out.println("Running DoublyLinkedList...");
                    DoublyLinkedList.main(args);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
