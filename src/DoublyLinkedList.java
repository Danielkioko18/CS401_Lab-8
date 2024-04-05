//Importing the needed library
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DoublyLinkedList {
    // DoublyLinkedList Node class 
    private static class Node {
        int id;
        String name;
        Node prev; //variable to represent the previous node on the list
        Node next; //variable to represent the next node on the list

        // Node Constructor to create the new node for this class
        Node(int id, String name) {
            this.id = id;
            this.name = name;
            prev = null;    //set the defaul value for previous node on the list
            next = null;    //set the defaul value for next node on the list
        }
    }

    private Node head;
    private Node tail;

    //The DoublyLinkedList Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // The add Method for adding element to the end of the list
    public void add(int id, String name) {
        Node newNode = new Node(id, name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    //  The  remove Method to enablke removal of an element from the list
    public void remove(int id) {
        if (head == null) {
            //Show error message incase the list is empty
            System.out.println("The Doubly Linked List Has no elements");
            return;
        }
        // set current node 
        Node current = head;
        while (current != null) {
            if (current.id == id) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                //display output message
                System.out.println("The Element with ID " + id + " has been removed from Doubly Linked List \n");
                return;
            }
            //rearrage the nodes to make current node be the next node
            current = current.next;
        }
        // error message in the case the entered id is not found
        System.out.println("The Element with ID " + id + "was not found in Doubly Linked List");
    }

    // The contains method
    public boolean contains(int id) {
        Node current = head;
        while (current != null) {
            if (current.id == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to display elements in the list
    // this will sho nthe userr the elements which are in the linked list
    public void display() {
        //check whether their are elements on the list
        if (head == null) {
            System.out.println("Doubly Linked List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.id + " " + current.name);
            current = current.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // Creating the new instance of DoublyLinkedList
        DoublyLinkedList doublyList = new DoublyLinkedList();

        // Adding the elements to the list
        doublyList.add(1, "Taylor");
        doublyList.add(2, "Smith");
        doublyList.add(3, "Johnson");

        // Displaying the added elements to the user
        System.out.println("Elements in the Doubly Linked List:\n");
        doublyList.display();

        // Prompting the  user to enter ID of the element he/she wants to remove
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Please Enter the ID of the element you want to remove from thje list: ");
            int removeId = Integer.parseInt(reader.readLine());
            doublyList.remove(removeId);
        } catch (IOException | NumberFormatException e) {
            System.out.println("\n Invalid input. Please enter a valid ID.");
        }

        // Display elements after removal
        System.out.println("Elements left in Doubly Linked List after removal: \n");
        doublyList.display();
    }
}