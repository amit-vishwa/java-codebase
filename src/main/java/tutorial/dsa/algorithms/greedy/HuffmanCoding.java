package tutorial.dsa.algorithms.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Refer: https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
 *
 * Huffman Coding: Creates an optimal prefix code for a set of symbols, minimizing the total encoding length.
 *
 * Huffman coding is a lossless data compression algorithm. The idea is to assign variable-length codes to input characters,
 * lengths of the assigned codes are based on the frequencies of corresponding characters.
 * The variable-length codes assigned to input characters are Prefix Codes, means the codes (bit sequences) are assigned in
 * such a way that the code assigned to one character is not the prefix of code assigned to any other character.
 * This is how Huffman Coding makes sure that there is no ambiguity when decoding the generated bitstream.
 * Let us understand prefix codes with a counter example. Let there be four characters a, b, c and d, and their corresponding
 * variable length codes be 00, 01, 0 and 1. This coding leads to ambiguity because code assigned to c is the prefix of
 * codes assigned to a and b. If the compressed bit stream is 0001, the de-compressed output may be “cccd” or “ccb” or
 * “acd” or “ab”.
 * See this for applications of Huffman Coding.
 *
 * There are mainly two major parts in Huffman Coding
 * Build a Huffman Tree from input characters.
 * Traverse the Huffman Tree and assign codes to characters.
 *
 * Algorithm:
 * The method which is used to construct optimal prefix code is called Huffman coding.
 *  This algorithm builds a tree in bottom up manner. We can denote this tree by T
 * Let, |c| be number of leaves
 * |c| -1 are number of operations required to merge the nodes. Q be the priority queue which can be used while constructing binary heap.
 *
 * Algorithm Huffman (c)
 * {
 *    n= |c|
 *    Q = c
 *    for i<-1 to n-1
 *    do
 *    {
 *        temp <- get node ()
 *       left (temp] Get_min (Q) right [temp] Get Min (Q)
 *       a = left [templ b = right [temp]
 *       F [temp]<- f[a] + [b]
 *       insert (Q, temp)
 *     }
 * return Get_min (0)
 * }
 *
 * Steps to build Huffman Tree
 * Input is an array of unique characters along with their frequency of occurrences and output is Huffman Tree.
 * i.Create a leaf node for each unique character and build a min heap of all leaf nodes (Min Heap is used as a priority queue. The value of frequency field is used to compare two nodes in min heap. Initially, the least frequent character is at root)
 * ii.Extract two nodes with the minimum frequency from the min heap.
 * iii.Create a new internal node with a frequency equal to the sum of the two nodes frequencies. Make the first extracted node as its left child and the other extracted node as its right child. Add this node to the min heap.
 * iv.Repeat steps#2 and #3 until the heap contains only one node. The remaining node is the root node and the tree is complete.
 *
 * Time complexity: O(nlogn) where n is the number of unique characters. If there are n nodes, extractMin() is called 2*(n – 1) times. extractMin() takes O(logn) time as it calls minHeapify(). So, the overall complexity is O(nlogn).
 * If the input array is sorted, there exists a linear time algorithm. We will soon be discussing this in our next post.
 *
 * Space complexity :- O(N)
 * */
public class HuffmanCoding {

    // main function
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        // number of characters.
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<HuffmanNode> q
                = new PriorityQueue<HuffmanNode>(
                n, new MyComparator());

        for (int i = 0; i < n; i++) {

            // creating a Huffman node object
            // and add it to the priority queue.
            HuffmanNode hn = new HuffmanNode();

            hn.c = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            // add functions adds
            // the huffman node to the queue.
            q.add(hn);
        }

        // create a root node
        HuffmanNode root = null;

        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.
        while (q.size() > 1) {

            // first min extract.
            HuffmanNode x = q.peek();
            q.poll();

            // second min extract.
            HuffmanNode y = q.peek();
            q.poll();

            // new node f which is equal
            HuffmanNode f = new HuffmanNode();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            f.data = x.data + y.data;
            f.c = '-';

            // first extracted node as left child.
            f.left = x;

            // second extracted node as the right child.
            f.right = y;

            // marking the f node as the root node.
            root = f;

            // add this node to the priority-queue.
            q.add(f);
        }

        // print the codes by traversing the tree
        printCode(root, "");
    }

    // recursive function to print the
    // huffman-code through the tree traversal.
    // Here s is the huffman - code generated.
    public static void printCode(HuffmanNode root, String s)
    {

        // base case; if the left and right are null
        // then its a leaf node and we print
        // the code s generated by traversing the tree.
        if (root.left == null && root.right == null
                && Character.isLetter(root.c)) {

            // c is the character in the node
            System.out.println(root.c + ":" + s);

            return;
        }

        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.

        // recursive calls for left and
        // right sub-tree of the generated tree.
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

}

// node class is the basic structure
// of each node present in the Huffman - tree.
class HuffmanNode {

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;
}

// comparator class helps to compare the node
// on the basis of one of its attribute.
// Here we will be compared
// on the basis of data values of the nodes.
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y)
    {

        return x.data - y.data;
    }
}