//Importing requeired libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

// the CircularLinkedList class
public class CircularLinkedList {
    private Node head;

    //the CircularLinkedList Constructor
    public CircularLinkedList() {
        head = null;
    }

    /* The insert Method 
    for insert elementS at the end of the circular linked list
    */
    public void insert(int id, String name) {
        Node newNode = new Node(id, name);

        /*
        Set the new node as head and make it circular If the list is empty
        */
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            //Find the last node and insert the new node after it IF its not empty
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head; // Making the new node circular
        }
    }

    // Display Method for displaying elements in the circular linked list
    public void display() {
        //check if list is empty
        if (head == null) {
            System.out.println("The Circular Linked List is empty and has no elements");
            return;
        }
        // if the list is not empty
        Node current = head;
        do {
            System.out.println(current.id + " " + current.name);
            current = current.next;
        } while (current != head);
        System.out.println("\n");
    }

    
    /* The Delete Method for deleting  an element by searching through ID */
    public void delete(int id) {
        // check wwhether list is empty
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return;
        }

        /* If head node itself holds the key to be deleted*/
        if (head.id == id) {
            /*If head is the only node in the list*/
            if (head.next == head) {
                head = null;
            } else {
                // Find the last node and update its next pointer
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }
                last.next = head.next;
                head = head.next;
            }
            return;
        }

        /* Searching for the key to be deleted and  keeping track of the
        / previous node as we need to change 'prev.next'*/
        Node prev = head;
        Node current = head.next;
        while (current != head && current.id != id) {
            prev = current;
            current = current.next;
        }

        if (current == head) {
            System.out.println("ID not found in Circular Linked List");
            return;
        }

        // Unlinking of the node from circular linked list
        prev.next = current.next;
    }
    
    /*
        deleteById method
        method to delete elemets by using their ID
    */
    public void deleteById() {
        // read input from user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // try catch statements for catching 
        try {
            System.out.print("Enter the ID of the element you want to delete: ");
            int id = Integer.parseInt(reader.readLine());
            delete(id);
            System.out.println("The Element with ID " + id + " deleted from Circular Linked List \n");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid ID.");
        }
    }

    //main mwthod
    public static void main(String[] args){
        /*
        new instance of CircularLinkedList
        */
        CircularLinkedList circularList = new CircularLinkedList();

        /* 
        Read data from emp.txt and add first 8 elements to the circular list
        */
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\NetBeansProjects\\CS401\\src\\emp.txt")))
        {
            String line;
            int count = 0;
            //loop until elements are 8
            while ((line = br.readLine()) != null && count < 8) {
                String[] parts = line.split(" ", 2);
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                circularList.insert(id, name);
                count++;
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        // Display the elements added to the list
        System.out.println("Elements in Circular Linked List:");
        circularList.display();
        
        // Prompting the user to delete an element by ID
        circularList.deleteById();

        // Displaying elements left after deletion
        System.out.println("Elements left in Circular Linked List after the deletion:");
        circularList.display();
    }
}
