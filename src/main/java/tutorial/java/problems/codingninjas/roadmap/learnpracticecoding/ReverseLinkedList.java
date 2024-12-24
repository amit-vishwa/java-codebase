package tutorial.java.problems.codingninjas.roadmap.learnpracticecoding;

import java.util.ArrayList;

public class ReverseLinkedList {
    public static void main(String... args){
        SingleLinkedList.insert(1);
        SingleLinkedList.insert(2);
        SingleLinkedList.insert(4);
        SingleLinkedList.insert(-1);
//        while (SingleLinkedList.head != null){
//            System.out.println(SingleLinkedList.head.data);
//            SingleLinkedList.head = SingleLinkedList.head.next;
//        }
        Node reversedList = TestReverseLinkedList.reverseLinkedList(SingleLinkedList.head);
        while (reversedList != null){
            System.out.println(reversedList.data);
            reversedList = reversedList.next;
        }
    }
}

class TestReverseLinkedList{
    public static Node reverseLinkedList(Node head)
    {
        // Write your code here.
        ArrayList<Integer> dataList = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            if(temp.data != -1)
            dataList.add(temp.data);
            temp = temp.next;
        }
        Node reversedLinkedList = null;
        for(int i = dataList.size()-1; i >= 0; i--){
            reversedLinkedList = insert(reversedLinkedList, dataList.get(i));
        }
        reversedLinkedList = insert(reversedLinkedList, -1);
        return reversedLinkedList;
    }

    public static Node insert(Node linkedList, int x){
        Node head = linkedList;
        Node node = new Node(x);
        if(head == null){
            head = node;
//            return head;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
//            return temp;
        }
        return head;
    }
}
