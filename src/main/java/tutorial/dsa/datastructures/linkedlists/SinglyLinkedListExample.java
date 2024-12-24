package tutorial.dsa.datastructures.linkedlists;

/**
 *
 * Refer: https://www.geeksforgeeks.org/singly-linked-list-tutorial/
 *
 * A singly linked list is a fundamental data structure, it consists of nodes where each node contains a data
 * field and a reference to the next node in the linked list. The next of the last node is null, indicating the
 * end of the list. Linked Lists support efficient insertion and deletion operations.
 *
 * Operations on Singly Linked List
 * i.Traversal
 * ii.Searching
 * iii.Length
 * iv.Insertion:
 * - Insert at the beginning
 * - Insert at the end
 * - Insert at a specific position
 * v.Deletion:
 * - Delete from the beginning
 * - Delete from the end
 * - Delete a specific node
 *
 * */
public class SinglyLinkedListExample {
    public static void main(String... args){
        tcOne();
    }

    static void tcOne(){
        SinglyLinkedList linkedList = new SinglyLinkedList(1);
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
        linkedList.insertionOfLinkedList();
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
        linkedList.traverseLinkedList();
        System.out.println("Does list contain key 40: " + linkedList.searchLinkedList(40));
        linkedList.deletionOfLinkedList();
//        linkedList.deletionOfLinkedList();
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
        linkedList.traverseLinkedList();
    }
}

class SinglyLinkedList{

    private Node head;

    public SinglyLinkedList(int data){
        head = new Node(data);
    }

    /**
     * 1.Traversal of Singly Linked List
     * Traversal involves visiting each node in the linked list and performing some operation on the data. A simple traversal function would print or process the data of each node.
     *
     * Step-by-step approach:
     *
     * Initialize a pointer current to the head of the list.
     * Use a while loop to iterate through the list until the current pointer reaches NULL.
     * Inside the loop, print the data of the current node and move the current pointer to the next node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void traverseLinkedList(){
        System.out.print("List elements: ");
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 2.Searching in Singly Linked List
     * Searching in a Singly Linked List refers to the process of looking for a specific element or value within the elements of the linked list.
     *
     * Step-by-step approach:
     *
     * Traverse the Linked List starting from the head.
     * Check if the current node's data matches the target value.
     * If a match is found, return true.
     * Otherwise, Move to the next node and repeat steps 2.
     * If the end of the list is reached without finding a match, return false.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean searchLinkedList(int key){
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 3.Length of Singly Linked List
     * Finding Length in Singly Linked List refers to the process of determining the total number of nodes in a singly linked list.
     *
     * Step-by-step approach:
     *
     * Initialize a counter length to 0.
     * Start from the head of the list, assign it to current.
     * Traverse the list:
     * Increment length for each node.
     * Move to the next node (current = current->next).
     * Return the final value of length.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public int lengthOfLinkedList(){
        int size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    /**
     * 4.Insertion in Singly Linked List
     * Insertion is a fundamental operation in linked lists that involves adding a new node to the list.
     * There are several scenarios for insertion.
     * */
    public void insertionOfLinkedList(){
        insertionAtBeginning(10);
        insertionAtEnd(100);
        insertionAtSpecifiedPosition(50, 3);
    }

    /**
     * 4.a. Insertion at the Beginning of Singly Linked List:
     * Step-by-step approach:
     *
     * - Create a new node with the given value.
     * - Set the next pointer of the new node to the current head.
     * - Move the head to point to the new node.
     * - Return the new head of the linked list.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    public boolean insertionAtBeginning(int x){
        Node node = new Node(x);
        node.next = head;
        head = node;
        System.out.println(x + " inserted at beginning");
        return true;
    }

    /**
     * 4.b. Insertion at the End of Singly Linked List:
     * To insert a node at the end of the list, traverse the list until the last node is reached, and then
     * link the new node to the current last node-
     * Step-by-step approach:
     *
     * - Create a new node with the given value.
     * - Check if the list is empty:
     * - If it is, make the new node the head and return.
     * - Traverse the list until the last node is reached.
     * - Link the new node to the current last node by setting the last node's next pointer to the new node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean insertionAtEnd(int x){
        Node node = new Node(x);
        if(head == null){
            node.next = head;
            head = node;
        } else{
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        System.out.println(x + " inserted at end");
        return true;
    }

    /**
     * 4.c. Insertion at a Specific Position of the Singly Linked List:
     * To insert a node at a specific position, traverse the list to the desired position, link the new node
     * to the next node, and update the links accordingly.
     * We mainly find the node after which we need to insert the new node. If we encounter a NULL before
     * reaching that node, it means that the given position is invalid.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean insertionAtSpecifiedPosition(int x, int pos){
        if(pos < 1){
            System.out.println("Invalid position!");
            return false;
        }
        if(pos == 1){
            return insertionAtBeginning(x);
        }
        // Traverse the list to find the node before the insertion point
        Node prev = head;
        int count = 1;
        while (count < pos-1 && prev != null){
            prev = prev.next;
            count++;
        }
        // If position is greater than the number of nodes
        if(prev == null){
            System.out.println("Invalid position!");
            return false;
        }
        // Insert the new node at the specified position
        Node temp = new Node(x);
        temp.next = prev.next;
        prev.next = temp;
        System.out.println(x + " inserted at position " + pos);
        return true;
    }

    /**
     * 5.Deletion in Singly Linked List
     * Deletion involves removing a node from the linked list. Similar to insertion, there are different
     * scenarios for deletion:
     * */
    public void deletionOfLinkedList(){
        deletionAtSpecifiedPosition(3);
        deletionAtBeginning();
        deletionAtEnd();
    }

    /**
     * 5.a. Deletion at the Beginning of Singly Linked List:
     * To delete the first node, update the head to point to the second node in the list.
     * Step-by-step approach:
     *
     * - Check if the head is NULL.
     * - If it is, return NULL (the list is empty).
     * - Store the current head node in a temporary variable temp.
     * - Move the head pointer to the next node.
     * - Delete the temporary node.
     * - Return the new head of the linked list.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    public boolean deletionAtBeginning(){
        if (head == null)
            return false;
        // Move the head pointer to the next node
        Node temp = head;
        head = head.next;
        System.out.println(temp.data + " deleted from beginning");
        temp = null;
        return true;
    }

    /**
     * 5.b. Deletion at the End of Singly Linked List:
     * To delete the last node, traverse the list until the second-to-last node and update its next field to None.
     * Step-by-step approach:
     *
     * - Check if the head is NULL.
     * - If it is, return NULL (the list is empty).
     * - Check if the head's next is NULL (only one node in the list).
     * - If true, delete the head and return NULL.
     * - Traverse the list to find the second last node (second_last).
     * - Delete the last node (the node after second_last).
     * - Set the next pointer of the second last node to NULL.
     * - Return the head of the linked list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean deletionAtEnd(){
        // If the list is empty, return null
        if (head == null)
            return false;
        // If the list has only one node, delete it and return null
        if (head.next == null) {
            head = null;
            return false;
        }
        // Find the second last node
        Node second_last = head;
        while (second_last.next.next != null){
            second_last = second_last.next;
        }
        System.out.println(second_last.next.data + " deleted from end");
        // Remove the last node
        second_last.next = null;
        // Return the modified list
        return true;
    }

    /**
     * 5.c. Deletion at a Specific Position of the Singly Linked List:
     * To delete a node at a specific position, traverse the list to the desired position, update the links
     * to bypass the node to be deleted.
     *
     * Step-by-step approach:
     *
     * - Check if the list is empty or the position is invalid, return if so.
     * - If the head needs to be deleted, update the head and delete the node.
     * - Traverse to the node before the position to be deleted.
     * - If the position is out of range, return.
     * - Store the node to be deleted.
     * - Update the links to bypass the node.
     * - Delete the stored node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean deletionAtSpecifiedPosition(int position){
        // If the list is empty or the position is invalid
        if (head == null || position < 1) {
            return false;
        }
        // If the head needs to be deleted
        if (position == 1) {
            Node temp = head;
            head = head.next;
            temp = null;
            return true;
        }
        // Traverse to the node before the position to be deleted
        Node current = head;
        for (int i = 1; i < position - 1 && current != null;
             i++) {
            current = current.next;
        }
        // If the position is out of range
        if (current == null || current.next == null) {
            return false;
        }
        // Store the node to be deleted
        Node temp = current.next;
        // Update the links to bypass the node to be deleted
        current.next = current.next.next;
        System.out.println(temp.data + " deleted from position " + position);
        // Delete the node
        temp = null;
        return true;
    }

}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}