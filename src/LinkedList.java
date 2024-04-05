
// Node class to be used in the programs
class Node {
    int id;
    String name;
    Node next;

    // Constructor to create a new node
    Node(int id, String name) {
        this.id = id;
        this.name = name;
        next = null;
    }
}

//The likedlist class
public class LinkedList {
     protected Node head;

    // The LinkedList Constructor
    public LinkedList() {
        head = null;
    }

    // The add method
    public void add(int id, String name) {
        Node newNode = new Node(id, name);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // The Remove method
    public void remove(int id) {
        Node current = head;
        Node prev = null;

        /* 
            If head node itself holds the key to be deleted
        */
        if (current != null && current.id == id) {
            head = current.next;
            return;
        }

        /* Search for the key to be deleted, keep track of the  
             previous node as we need to change 'prev.next'        
        */
        while (current != null && current.id != id) {
            prev = current;
            current = current.next;
        }

        // If the key was not present in the list
        if (current == null) return;

        // Unlink the node from linked list
        prev.next = current.next;
    }

    // The contains method
    public boolean contains(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
