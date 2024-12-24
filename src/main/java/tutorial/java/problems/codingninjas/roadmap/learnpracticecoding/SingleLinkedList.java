package tutorial.java.problems.codingninjas.roadmap.learnpracticecoding;

public class SingleLinkedList {

    static Node head = null;

    static void insert(int x)
    {
        // Allocate the temp Node and
        // put x as data into it
        Node temp = new Node(x);

        // Check if the head is NULL
        if (head == null) {
            head = temp;
            return;
        }
        else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
    }

    public static int searchInLinkedList(Node head, int k)
    {
        // Write Your Code Here.
        Node temp = head;
        while (temp != null){
            if(temp.data == k){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
    public static void main(String... args){
        insert(5);insert(4);insert(12);insert(7);
        System.out.println(searchInLinkedList(SingleLinkedList.head,112));
    }

}

 // Following is the class structure of the Node class:
 class Node {
 public int data;
 public Node next;

 Node()
 {
 this.data = 0;
 this.next = null;
 }

 Node(int data)
 {
 this.data = data;
 this.next = null;
 }

 Node(int data, Node next)
 {
 this.data = data;
 this.next = next;
 }
 }