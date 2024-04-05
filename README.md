==========================
    LINKEDLIST PROGRAM
==========================
                            
This program implements various types of linked lists in Java. 
It includes implementations for sorted linked list, circular linked list, and doubly linked list.

======================
Program Files:
======================


Main.java: 
This is the program that contains the main class of the program. 
It prompts the user to choose between running SortedLinkedList,CircularLinkedList or DoublyLinkedList, 
and then executes the chosen class accordingly. it is also the launcher of the whole program.


SortedLinkedList.java: 
This program implements a sorted linked list. It reads data from a file (emp.txt), sorts the data based on  IDs, 
and prints the sorted list for the user to see the sorted list. it inherits the LinkedList class.
It contains its own main method, thus it can be ran independently.


CircularLinkedList.java: 
This program implements a circular linked list.it also reads data from the emp.txt file. 
It adds the first 8 elements from the file into the list. 
It contains its own main method and can be run independently to insert elements and display the list. 
This program also has remove method to remove elemnt of choice from the list and displays left elements to the user


DoublyLinkedList.java: 
This program implements a doubly linked list. Similar to CircularLinkedList, it contains its own main method and can be run independently to perform operations such as adding, removing, and displaying elements in the list.The elements are added on the program.

emp.txt: 
This is the file that contains the data used in the format <ID> <Name>. This data is used by the SortedLinkedList and CircularLinkedList  class to populate the sorted list and get 8 elements respectively.

=========================
RUNNING THE PROGRAMS:
=========================

All the .java programs can be run independently as they have main methods. 
you can use the command prompt or java IDE
to use command prompt, navigate to directory you have placed the java files and run these commands
1. javac *.java -to compile them
2. java filename - to run file you want


To run the whole program(the cs401.jar file), use this command:
1. ava -jar "CS401.jar" 

the program will supply you with a menu to to choose what program you want to run

Follow the prompts to choose between running SortedLinkedList, CircularLinkedList or DoublyLinkedList. 
The chosen class will then be executed, and you can interact with it accordingly.