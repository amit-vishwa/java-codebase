package tutorial.dsa.datastructures.linkedlists;

/**
 *
 * Refer: https://www.geeksforgeeks.org/doubly-linked-list/
 *
 * A doubly linked list is a more complex data structure than a singly linked list, but it offers several
 * advantages. The main advantage of a doubly linked list is that it allows for efficient traversal of the list
 * in both directions. This is because each node in the list contains a pointer to the previous node and a
 * pointer to the next node. This allows for quick and easy insertion and deletion of nodes from the list, as
 * well as efficient traversal of the list in both directions.
 *
 * What is a Doubly Linked List?
 * A doubly linked list is a data structure that consists of a set of nodes, each of which contains a value and
 * two pointers, one pointing to the previous node in the list and one pointing to the next node in the list.
 * This allows for efficient traversal of the list in both directions, making it suitable for applications where
 * frequent insertions and deletions are required.
 *
 * Operations on Doubly Linked List
 * i.Traversal in Doubly Linked List
 * ii.Searching in Doubly Linked List
 * iii.Finding Length of Doubly Linked List
 * iv.Insertion in Doubly Linked List:
 * - Insertion at the beginning of Doubly Linked List
 * - Insertion at the end of the Doubly Linked List
 * - Insertion at a specific position in Doubly Linked List
 * v.Deletion in Doubly Linked List:
 * - Deletion of a node at the beginning of Doubly Linked List
 * - Deletion of a node at the end of Doubly Linked List
 * - Deletion of a node at a specific position in Doubly Linked List
 *
 * */
public class DoublyLinkedListExample {
    public static void main(String[] args){
        tcOne();
    }
    static void tcOne(){
        DoublyLinkedList linkedList = new DoublyLinkedList(1);
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
        linkedList.insertionOfLinkedList();
        linkedList.insertionOfLinkedList();
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
        linkedList.traverseLinkedList();
        System.out.println("Does list contain key 100: " + linkedList.searchLinkedList(100));
        linkedList.deletionOfLinkedList();
        linkedList.deletionOfLinkedList();
//        linkedList.deletionOfLinkedList();
        System.out.println("List size: " + linkedList.lengthOfLinkedList());
    }
}

class DoublyLinkedList{

    private DoublyNode head, tail;

    public DoublyLinkedList(int x){
        head = new DoublyNode(x);
        // Initialize head and tail with same node
        tail = head;
    }

    /**
     * 1.Traversal in Doubly Linked List
     * To Traverse the doubly list, we can use the following steps:
     *
     * a. Forward Traversal:
     * Initialize a pointer to the head of the linked list.
     * While the pointer is not null:
     * Visit the data at the current node.
     * Move the pointer to the next node.
     *
     * b. Backward Traversal:
     * Initialize a pointer to the tail of the linked list.
     * While the pointer is not null:
     * Visit the data at the current node.
     * Move the pointer to the previous node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public void traverseLinkedList(){
        traverseForward();
        traverseBackward();
    }
    private void traverseForward(){
        System.out.print("Forward list elements: ");
        DoublyNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    private void traverseBackward(){
        System.out.print("Backward list elements: ");
        DoublyNode temp = tail;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    /**
     * 2.Searching element in Doubly Linked List
     * To find the key in doubly list, we can use the following steps:
     *
     * Start at the head of the list.
     * Traverse through the list, check if data is equal to key or not.
     * Return true if found, false otherwise.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public boolean searchLinkedList(int key){
        DoublyNode temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 3.Finding Length of Doubly Linked List
     * To find the length of doubly list, we can use the following steps:
     *
     * Start at the head of the list.
     * Traverse through the list, counting each node visited.
     * Return the total count of nodes as the length of the list.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public int lengthOfLinkedList(){
        DoublyNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 4. Insertion in Doubly Linked List
     * */
    public void insertionOfLinkedList(){
        insertionAtBeginning(10);
        insertionAtEnd(100);
        insertionAtPosition(50, 3);
    }

    /**
     * 4.a. Insertion at the Beginning in Doubly Linked List
     * To insert a new node at the beginning of the doubly list, we can use the following steps:
     *
     * Create a new node, say new_node with the given data and set its previous pointer to null, new_node->prev = NULL.
     * Set the next pointer of new_node to current head, new_node->next = head.
     * If the linked list is not empty, update the previous pointer of the current head to new_node, head->prev = new_node.
     * Return new_node as the head of the updated linked list.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    private void insertionAtBeginning(int x){
        DoublyNode node = new DoublyNode(x);
        node.next = head;
        // If head is not null, update head previous to node
        if (head != null) {
            head.prev = node;
        }
        // Move head pointer to node
        head = node;
        // If tail is null, update tail to node
        if (tail == null) {
            tail = node;
        }
        System.out.println(x + " inserted at beginning");
    }

    /**
     * 4.b. Insertion at the End of Doubly Linked List
     * To insert a new node at the end of the doubly linked list, we can use the following steps:
     *
     * Allocate memory for a new node and assign the provided value to its data field.
     * Initialize the next pointer of the new node to nullptr.
     * If the list is empty:
     * Set the previous pointer of the new node to nullptr.
     * Update the head pointer to point to the new node.
     * If the list is not empty:
     * Traverse the list starting from the head to reach the last node.
     * Set the next pointer of the last node to point to the new node.
     * Set the previous pointer of the new node to point to the last node.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    private void insertionAtEnd(int x){
        DoublyNode node = new DoublyNode(x);
        if(tail == null){
            // If tail is null, update head and tail to node
            head = tail = node;
        }else{
            // Update tail next to node
            tail.next = node;
            // Node previous is tail now
            node.prev = tail;
            // Move tail pointer to node
            tail = node;
        }
        System.out.println(x + " inserted at end");
    }

    /**
     * 4.c. Insertion at a Specific Position in Doubly Linked List
     *
     * To insert a new node at a specific position,
     *
     * If position = 1, create a new node and make it the head of the linked list and return it.
     * Otherwise, traverse the list to reach the node at position – 1, say curr.
     * If the position is valid, create a new node with given data, say new_node.
     * Update the next pointer of new node to the next of current node and prev pointer of new node to current node, new_node->next = curr->next and new_node->prev = curr.
     * Similarly, update next pointer of current node to the new node, curr->next = new_node.
     * If the new node is not the last node, update prev pointer of new node’s next to the new node, new_node->next->prev = new_node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    private void insertionAtPosition(int x, int pos){
        if(pos < 1){
            System.out.println("Invalid position!");
            return;
        }
        if(pos == 1){
            insertionAtBeginning(x);
            return;
        }
        DoublyNode temp = head;
        // Traverse list till before of specified position
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        // If node at specified position is null, return
        if(temp == null){
            System.out.println("Invalid position!");
            return;
        }
        DoublyNode node = new DoublyNode(x);
        // Set the prev of new node to curr
        node.prev = temp;
        // Set the next of new node to next of curr
        node.next = temp.next;
        // Update previous of head next to node
        if (temp.next != null) {
            temp.next.prev = node;
        }
        // Update the next of head node to new node
        temp.next = node;
        // If last position, then update tail
        if (node.next == null) {
            tail = node;
        }
        System.out.println(x + " inserted at position " + pos);
    }

    /**
     * 5. Deletion in Doubly Linked List
     * */
    public void deletionOfLinkedList(){
        deletionAtPosition(3);
        traverseLinkedList();
        deletionAtBeginning();
        traverseLinkedList();
        deletionAtEnd();
        traverseLinkedList();
    }

    /**
     * 5.a. Deletion at the Beginning of Doubly Linked List
     *
     * To delete a node at the beginning in doubly linked list, we can use the following steps:
     *
     * Check if the list is empty, there is nothing to delete. Return.
     * Store the head pointer in a variable, say temp.
     * Update the head of linked list to the node next to the current head, head = head->next.
     * If the new head is not NULL, update the previous pointer of new head to NULL, head->prev = NULL.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    private void deletionAtBeginning(){
        if(head == null){
            return;
        }
        System.out.println(head.data + " deleted from beginning");
        // Move the head pointer to the next node
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
    }

    /**
     * 5.b. Deletion at the End of Doubly Linked List
     *
     * To delete a node at the end in doubly linked list, we can use the following steps:
     *
     * Check if the doubly linked list is empty. If it is empty, then there is nothing to delete.
     * If the list is not empty, then move to the last node of the doubly linked list, say curr.
     * Update the second-to-last node's next pointer to NULL, curr->prev->next = NULL.
     * Free the memory allocated for the node that was deleted.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     * */
    private void deletionAtEnd(){
        if(tail == null){
            return;
        }
        System.out.println(tail.data + " deleted from end");
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
    }

    /**
     * 5.c. Deletion at a Specific Position in Doubly Linked List
     *
     * To delete a node at a specific position in doubly linked list, we can use the following steps:
     *
     * Traverse to the node at the specified position, say curr.
     * If the position is valid, adjust the pointers to skip the node to be deleted.
     * If curr is not the head of the linked list, update the next pointer of the node before curr to point
     * to the node after curr, curr->prev->next = curr-next.
     * If curr is not the last node of the linked list, update the previous pointer of the node after curr
     * to the node before curr, curr->next->prev = curr->prev.
     * Free the memory allocated for the deleted node.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    private void deletionAtPosition(int pos){
        if(pos < 1){
            return;
        }
        if(pos == 1){
            deletionAtBeginning();
            return;
        }
        DoublyNode curr = head;
        // Traverse till specified position
        for (int i = 1; i < pos && curr != null; i++) {
            curr = curr.next;
        }
        // If node is null, return
        if (curr == null) {
            System.out.println("Invalid position!");
            return;
        }
        System.out.println(curr.data + " deleted from position " + pos);
        // Update the previous node's next pointer
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        // Update the next node's prev pointer
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
        // If node is tail then store previous of node in tail
        if (curr == tail) {
            tail = curr.prev;
        }
    }

}

/**
 * Each node in a Doubly Linked List contains the data it holds, a pointer to the next node in the list,
 * and a pointer to the previous node in the list. By linking these nodes together through the next and prev
 * pointers, we can traverse the list in both directions (forward and backward), which is a key feature of a
 * Doubly Linked List.
 * */
class DoublyNode{
    int data;
    DoublyNode prev;
    DoublyNode next;
    public DoublyNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
