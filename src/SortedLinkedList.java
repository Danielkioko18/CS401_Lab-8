
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// The SortedLinkedList which extents the LinkedList
public class SortedLinkedList extends LinkedList {
     // add method to add list of the elements from emp.txt file
    @Override
    public void add(int id, String name) {
        Node newNode = new Node(id, name);

        /* 
        If the list is empty or the new node's ID is less than the head's ID
        */
        if (head == null || id < head.id) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            // Finding the appropriate position to insert the new node
            while (current.next != null && current.next.id < id) {
                current = current.next;
            }

            // Insert the new node to the list
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    //Main method
    public static void main(String[] args) {
        SortedLinkedList sortedList = new SortedLinkedList();

        // Read the data from emp.txt and add employees to the sorted list
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\NetBeansProjects\\CS401\\src\\emp.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                sortedList.add(id, name);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // Print the sorted list for user to view
        Node current = sortedList.head;
        System.out.println("The Sorted List:");
        while (current != null) {
            System.out.println(current.id + " " + current.name);
            current = current.next;
        }
    }
    
    
}
