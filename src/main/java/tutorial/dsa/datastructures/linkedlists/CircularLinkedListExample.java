package tutorial.dsa.datastructures.linkedlists;

/**
 *
 * Refer: https://www.geeksforgeeks.org/circular-linked-list/
 *
 * A circular linked list is a data structure where the last node connects back to the first, forming a loop.
 * This structure allows for continuous traversal without any interruptions. Circular linked lists are especially
 * helpful for tasks like scheduling and managing playlists, this allowing for smooth navigation.
 *
 * What is a Circular Linked List?
 * A circular linked list is a special type of linked list where all the nodes are connected to form a circle.
 * Unlike a regular linked list, which ends with a node pointing to NULL, the last node in a circular linked list
 * points back to the first node. This means that you can keep traversing the list without ever reaching a NULL value.
 *
 * Types of Circular Linked Lists
 * We can create a circular linked list from both singly linked lists and doubly linked lists. So, circular linked
 * list are basically of two types:
 *
 * 1. Circular Singly Linked List
 * In Circular Singly Linked List, each node has just one pointer called the “next” pointer. The next pointer of
 * last node points back to the first node and this results in forming a circle. In this type of Linked list we
 * can only move through the list in one direction.
 *
 * 2. Circular Doubly Linked List:
 * In circular doubly linked list, each node has two pointers prev and next, similar to doubly linked list.
 * The prev pointer points to the previous node and the next points to the next node. Here, in addition to the
 * last node storing the address of the first node, the first node will also store the address of the last node.
 *
 * Operations on the Circular Linked list:
 * We can do some operations on the circular linked list similar to the singly and doubly linked list which are:
 *
 * Insertion
 * - Insertion at the empty list
 * - Insertion at the beginning
 * - Insertion at the end
 * - Insertion at the given position
 * Deletion
 * - Delete the first node
 * - Delete the last node
 * - Delete the node from any position
 * Searching
 *
 * */
public class CircularLinkedListExample {
    public static void main(String args[]){
        tcOne();
        System.out.println();
        tcTwo();
    }
    static void tcOne(){
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.insertionInEmptyList(23);
        circularSinglyLinkedList.insertionInEmptyList(56);
        circularSinglyLinkedList.printCircularLinkedList();
        circularSinglyLinkedList.insertionAtPosition(5,5);
        circularSinglyLinkedList.insertionAtEnd(6);
        circularSinglyLinkedList.insertionAtPosition(20,2);
        circularSinglyLinkedList.printCircularLinkedList();
        System.out.println("Is 5 exists in list: " + circularSinglyLinkedList.searchCircularLinkedList(5));
        System.out.println("Is 6 exists in list: " + circularSinglyLinkedList.searchCircularLinkedList(6));
        circularSinglyLinkedList.insertionAtBeginning(40);
        circularSinglyLinkedList.insertionAtBeginning(21);
        circularSinglyLinkedList.insertionAtPosition(5,5);
        System.out.println("Is 5 exists in list: " + circularSinglyLinkedList.searchCircularLinkedList(5));
        circularSinglyLinkedList.printCircularLinkedList();
        circularSinglyLinkedList.deletionAtPosition(10);
        circularSinglyLinkedList.deletionAtBeginning();
        circularSinglyLinkedList.deletionAtEnd();
        circularSinglyLinkedList.printCircularLinkedList();
        circularSinglyLinkedList.deletionAtBeginning();
        circularSinglyLinkedList.deletionAtEnd();
        circularSinglyLinkedList.deletionAtBeginning();
        circularSinglyLinkedList.deletionAtEnd();
        circularSinglyLinkedList.deletionAtBeginning();
        circularSinglyLinkedList.deletionAtEnd();
        circularSinglyLinkedList.printCircularLinkedList();
    }
    static void tcTwo(){
        CircularDoublyLinkedList circulardoublyLinkedList = new CircularDoublyLinkedList();
        circulardoublyLinkedList.insertionInEmptyList(23);
        circulardoublyLinkedList.insertionInEmptyList(56);
        circulardoublyLinkedList.printCircularLinkedList();
        circulardoublyLinkedList.insertionAtPosition(5,5);
        circulardoublyLinkedList.insertionAtEnd(6);
        circulardoublyLinkedList.insertionAtPosition(20,2);
        circulardoublyLinkedList.printCircularLinkedList();
        System.out.println("Is 5 exists in list: " + circulardoublyLinkedList.searchCircularLinkedList(5));
        System.out.println("Is 6 exists in list: " + circulardoublyLinkedList.searchCircularLinkedList(6));
        circulardoublyLinkedList.insertionAtBeginning(40);
        circulardoublyLinkedList.insertionAtBeginning(21);
        circulardoublyLinkedList.insertionAtPosition(5,5);
        System.out.println("Is 5 exists in list: " + circulardoublyLinkedList.searchCircularLinkedList(5));
        circulardoublyLinkedList.printCircularLinkedList();
        circulardoublyLinkedList.deletionAtPosition(10);
        circulardoublyLinkedList.deletionAtBeginning();
        circulardoublyLinkedList.deletionAtEnd();
        circulardoublyLinkedList.printCircularLinkedList();
        circulardoublyLinkedList.deletionAtBeginning();
        circulardoublyLinkedList.deletionAtEnd();
        circulardoublyLinkedList.deletionAtBeginning();
        circulardoublyLinkedList.deletionAtEnd();
        circulardoublyLinkedList.deletionAtBeginning();
        circulardoublyLinkedList.deletionAtEnd();
        circulardoublyLinkedList.printCircularLinkedList();
    }
}

///////////////////////////////////////// Circular Singly Linked List //////////////////////////////////////////////////////

class CircularSinglyLinkedList{

    private Node head;

    public CircularSinglyLinkedList(){}

    public CircularSinglyLinkedList(int data){
        head = new Node(data);
        // Pointing head to itself
        head.next = head;
    }

    // 1. Insertion in the circular linked list:

    /**
     * 1.a. Insertion in an empty List in the circular linked list
     * To insert a node in empty circular linked list, creates a new node with the given data, sets its next
     * pointer to point to itself, and updates the last pointer to reference this new node.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    public void insertionInEmptyList(int x){
        // If list is not empty then return
        if(head != null){
            return;
        }
        // Create a node
        Node temp = new Node(x);
        // Point node to itself
        temp.next = temp;
        // Update head to point node
        head = temp;
        System.out.println(x + " inserted in empty list");
    }

    /**
     * 1.b. Insertion at the beginning in circular linked list
     * To insert a new node at the beginning of a circular linked list, we first create the new node and allocate
     * memory for it. If the list is empty (indicated by the last pointer being NULL), we make the new node point
     * to itself. If the list already contains nodes then we set the new node’s next pointer to point to the
     * current head of the list (which is last->next), and then update the last node’s next pointer to point to
     * the new node. This maintains the circular structure of the list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void insertionAtBeginning(int x){
        Node node = new Node(x);
        // If the list is empty, make the new node point to itself and set it as last
        if(head == null){
            insertionInEmptyList(x);
            return;
        }
        Node temp = head;
        // Traverse till last node
        while (temp.next != head) {
            temp = temp.next;
        }
        // Insert the new node at the beginning
        node.next = head;
        temp.next = node;
        head = node;
        System.out.println(x + " inserted at the beginning");
    }

    /**
     * 1.c. Insertion at the end in circular linked list
     * To insert a new node at the end of a circular linked list, we first create the new node and allocate
     * memory for it. If the list is empty (mean, last or tail pointer being NULL), we initialize the list
     * with the new node and making it point to itself to form a circular structure. If the list already
     * contains nodes then we set the new node’s next pointer to point to the current head (which is
     * tail->next), then update the current tail’s next pointer to point to the new node. Finally, we update
     * the tail pointer to the new node. This will ensure that the new node is now the last node in the
     * list while maintaining the circular linkage.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void insertionAtEnd(int x){
        Node node = new Node(x);
        // If the list is empty, make the new node point to itself and set it as last
        if(head == null){
            insertionInEmptyList(x);
            return;
        }
        Node temp = head;
        // Traverse list till end
        while (temp.next != head){
            temp = temp.next;
        }
        // Point node to last next i.e. head
        node.next = head;
        // Point last node to new node
        temp.next = node;
        System.out.println(x + " inserted at the end");
    }

    /**
     * 1.d. Insertion at specific position in circular linked list
     *
     * To insert a new node at a specific position in a circular linked list, we first check if the list is
     * empty. If it is and the position is not 1 then we print an error message because the position doesn’t
     * exist in the list. If the position is 1 then we create the new node and make it point to itself.
     * If the list is not empty, we create the new node and traverse the list to find the correct insertion
     * point. If the position is 1, we insert the new node at the beginning by adjusting the pointers
     * accordingly. For other positions, we traverse through the list until we reach the desired position and
     * inserting the new node by updating the pointers. If the new node is inserted at the end, we also update
     * the last pointer to reference the new node, maintaining the circular structure of the list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void insertionAtPosition(int x, int pos){
        if(pos < 1){
            System.out.println("Invalid position!");
            return;
        }
        if(pos == 1){
            insertionAtBeginning(x);
            return;
        }
        // Traverse the list to find the node before the insertion point
        Node prev = head;
        int count = 1;
        while (count < pos - 1 && prev.next != head) {
            prev = prev.next;
            count++;
        }
        // If position is greater than the number of nodes
        if(prev.next == head && count < pos - 1){
            System.out.println("Invalid position!");
            return;
        }
        // Insert the new node at the specified position
        Node temp = new Node(x);
        temp.next = prev.next;
        prev.next = temp;
        System.out.println(x + " inserted at position " + pos);
    }

    // 2. Deletion in the circular linked list:

    /**
     * 2.a. Delete the first node in circular linked list
     *
     * To delete the first node of a circular linked list, we first check if the list is empty. If it is then
     * we print a message and return NULL. If the list contains only one node (the head is the same as the
     * last) then we delete that node and set the last pointer to NULL. If there are multiple nodes then we
     * update the last->next pointer to skip the head node and effectively removing it from the list. We then
     * delete the head node to free the allocated memory. Finally, we return the updated last pointer, which
     * still points to the last node in the list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void deletionAtBeginning(){
        if (head == null) {
            // If the list is empty
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        if (temp.next == head) {
            // If there is only one node in the list
            head = null;
        } else {
            // Traverse to update last node next pointer
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            System.out.println(head.data + " deleted from beginning");
            // More than one node in the list
            head = head.next;
        }
    }

    /**
     * 2.b. Delete the last node in circular linked list
     *
     * To delete the last node in a circular linked list, we first check if the list is empty. If it is,
     * we print a message and return nullptr. If the list contains only one node (where the head is the same
     * as the last), we delete that node and set last to nullptr. For lists with multiple nodes, we need to
     * traverse the list to find the second last node. We do this by starting from the head and moving through
     * the list until we reach the node whose next pointer points to last. Once we find the second last node
     * then we update its next pointer to point back to the head, this effectively removing the last node from
     * the list. We then delete the last node to free up memory and return the updated last pointer, which
     * now points to the last node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void deletionAtEnd(){
        if (head == null) {
            // If the list is empty
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        // If there is only one node in the list
        if (temp.next == head) {
            System.out.println(temp.data + " deleted from end");
            head = null;
            return;
        }
        // Traverse the list to find the second last node
        while (temp.next.next != head) {
            temp = temp.next;
        }
        System.out.println(temp.next.data + " deleted from end");
        // Update the second last node's next pointer to point to head
        temp.next = head;

    }

    /**
     * 2.c. Delete a specific node in circular linked list
     *
     * To delete a specific node from a circular linked list, we first check if the list is empty. If it is
     * then we print a message and return nullptr. If the list contains only one node and it matches the key
     * then we delete that node and set last to nullptr. If the node to be deleted is the first node then we
     * update the next pointer of the last node to skip the head node and delete the head. For other nodes,
     * we traverse the list using two pointers: curr (to find the node) and prev (to keep track of the
     * previous node). If we find the node with the matching key then we update the next pointer of prev to
     * skip the curr node and delete it. If the node is found and it is the last node, we update the last
     * pointer accordingly. If the node is not found then do nothing and tail or last as it is. Finally, we
     * return the updated last pointer.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void deletionAtPosition(int position){
        if(head == null){
            // If the list is empty
            System.out.println("List is empty");
            return;
        }
        if (position < 1) {
            // If position is invalid
            System.out.println("Invalid position!");
            return;
        }
        // If the head needs to be deleted
        if (position == 1) {
            deletionAtBeginning();
            return;
        }
        // Traverse to the node before the position to be deleted
        Node current = head;
        for (int i = 1; i < position - 1 && current.next != head;
             i++) {
            current = current.next;
        }
        if (current.next == head) {
            System.out.println("Invalid position!");
            return;
        }
        System.out.println(current.next.data + " deleted from position " + position);
        // Update the links to bypass the node to be deleted
        current.next = current.next.next;
    }

    /**
     * 3. Searching in Circular Linked list
     * Searching in a circular linked list is similar to searching in a regular linked list. We start at a given
     * node and traverse the list until you either find the target value or return to the starting node.
     * Since the list is circular, make sure to keep track of where you started to avoid an infinite loop.
     *
     * To search for a specific value in a circular linked list, we first check if the list is empty. If it is
     * then we return false. If the list contains nodes then we start from the head node (which is the last->next)
     * and traverse the list. We use a pointer curr to iterate through the nodes until we reach back to the head.
     * During traversal, if we find a node whose data matches the given key then we return true to indicating that
     * the value was found. After the loop, we also check the last node to ensure we don’t miss it. If the key is
     * not found after traversing the entire list then we return false.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean searchCircularLinkedList(int key){
        Node temp = head;
        do {
            if(key == temp.data){
                return true;
            }
            temp = temp.next;
        }while (temp != head);
        return false;
    }

    public void printCircularLinkedList(){
        Node temp = head;
        if(temp == null){
            return;
        }
        System.out.print("Circular linked list elements: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }while (temp != head);
        System.out.println();
    }

}

///////////////////////////////////////// Circular Doubly Linked List //////////////////////////////////////////////////////

/**
 * Refer: https://www.geeksforgeeks.org/insertion-in-doubly-circular-linked-list/
 *
 * CircularDoublyLinkedList is a data structure where each node has two pointers,
 * one pointing to the next node and one to the previous node, forming a circular structure.
 * This allows for traversal in both directions without any interruptions.
 *
 * Insertion at the Beginning in Doubly Circular Linked List – O(1) Time and O(1) Space
 * Insertion at the End in Doubly Circular Linked List – O(1) Time and O(1) Space
 * Insertion after a given node in Doubly Circular Linked List – O(n) Time and O(1) Space
 * Insertion before a given node in Doubly Circular Linked List – O(n) Time and O(1) Space
 * Insertion at a specific position in Doubly Circular Linked List – O(n) Time and O(1) Space *
 */
class CircularDoublyLinkedList {

    private DoublyNode head;

    /**
     * Default constructor for CircularDoublyLinkedList.
     */
    public CircularDoublyLinkedList() {}

    /**
     * Constructor to initialize the list with a single node.
     * @param data the data for the initial node.
     */
    public CircularDoublyLinkedList(int data) {
        head = new DoublyNode(data);
        head.next = head;
        head.prev = head;
    }

    /**
     * Inserts a node into an empty list.
     * @param x the data for the new node.
     */
    public void insertionInEmptyList(int x) {
        if (head != null) {
            return;
        }
        DoublyNode temp = new DoublyNode(x);
        temp.next = temp;
        temp.prev = temp;
        head = temp;
        System.out.println(x + " inserted in empty list");
    }

    /**
     * Inserts a node at the beginning of the list.
     * @param x the data for the new node.
     */
    public void insertionAtBeginning(int x) {
        DoublyNode node = new DoublyNode(x);
        if (head == null) {
            insertionInEmptyList(x);
            return;
        }
        // Connect node with head and tail
        DoublyNode last = head.prev;
        node.next = head;
        node.prev = last;
        // Update head and tail pointers
        head.prev = node;
        last.next = node;
        head = node;
        System.out.println(x + " inserted at the beginning");
    }

    /**
     * Inserts a node at the end of the list.
     * @param x the data for the new node.
     */
    public void insertionAtEnd(int x) {
        DoublyNode node = new DoublyNode(x);
        if (head == null) {
            insertionInEmptyList(x);
            return;
        }
        DoublyNode last = head.prev;
        node.next = head;
        node.prev = last;
        last.next = node;
        head.prev = node;
        // Similar implementation as of beginning only not storing node in head
        System.out.println(x + " inserted at the end");
    }

    /**
     * Inserts a node at a specific position in the list.
     * @param x the data for the new node.
     * @param pos the position to insert the new node.
     */
    public void insertionAtPosition(int x, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            insertionAtBeginning(x);
            return;
        }
        DoublyNode temp = head;
        // Traverse till the position
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Invalid position!");
            return;
        }
        // Place node at specified position
        DoublyNode node = new DoublyNode(x);
        node.next = temp.next;
        node.prev = temp;
        // Update the pointers
        temp.next.prev = node;
        temp.next = node;
        System.out.println(x + " inserted at position " + pos);
    }

    /**
     * Deletes the node at the beginning of the list.
     */
    public void deletionAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            // Single node
            head = null;
        } else {
            DoublyNode last = head.prev;
            System.out.println(head.data + " deleted from beginning");
            head = head.next;
            head.prev = last;
            last.next = head;
        }
    }

    /**
     * Deletes the node at the end of the list.
     */
    public void deletionAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            // Single node
            System.out.println(head.data + " deleted from end");
            head = null;
        } else {
            DoublyNode last = head.prev;
            System.out.println(last.data + " deleted from end");
            last.prev.next = head;
            head.prev = last.prev;
        }
    }

    /**
     * Deletes the node at a specific position in the list.
     * @param position the position of the node to delete.
     */
    public void deletionAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            deletionAtBeginning();
            return;
        }
        DoublyNode temp = head;
        for (int i = 1; i < position && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Invalid position!");
            return;
        }
        System.out.println(temp.data + " deleted from position " + position);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    /**
     * Searches for a node with a specific key in the list.
     * @param key the data to search for.
     * @return true if the node is found, false otherwise.
     */
    public boolean searchCircularLinkedList(int key) {
        DoublyNode temp = head;
        do {
            if (key == temp.data) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    /**
     * Prints the elements of the circular doubly linked list.
     */
    public void printCircularLinkedList() {
        DoublyNode temp = head;
        if (temp == null) {
            return;
        }
        System.out.print("Circular linked list elements: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

}