package tutorial.dsa.datastructures.trees.degreewise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Refer:https://www.geeksforgeeks.org/what-is-generic-tree-or-n-ary-tree/?ref=rp,
 * https://www.geeksforgeeks.org/generic-tree-level-order-traversal/,
 * https://www.geeksforgeeks.org/generic-treesn-array-trees/?ref=lbp
 *
 * Generic tree or an N-ary tree is a versatile data structure used to organize data hierarchically. Unlike binary
 * trees that have at most two children per node, generic trees can have any number of child nodes. This flexibility
 * makes them suitable for representing hierarchical data where each node can have several branches or children.
 *
 * What is a Generic Tree?
 * A generic tree is a tree where each node can have zero or more children nodes. Unlike a binary tree, which has
 * at most two children per node (left and right), a generic tree allows for multiple branches or children for each node.
 *
 * Applications of Generic Tree or N-ary Tree
 * Below are some application of generic tree:
 * - File Systems: Representing directories and files where directories can contain other directories or files.
 * - Organization Structures: Modeling hierarchical relationships in organizations where each node represents a person or a department.
 * - Compiler Design: Representing the structure of statements and expressions in programming languages.
 * - XML/HTML Parsing: Storing and traversing hierarchical data structures like XML or HTML documents.
 *
 * Time Complexity: O(n) where n is the number of nodes in the n-ary tree.
 * Auxiliary Space: O(n)
 * */
public class NAryTree {

    // Represents a node of an n-ary tree
    static class Node
    {
        int key;
        Vector<Node > child = new Vector<>();
    };

    // Utility function to create a new tree node
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        return temp;
    }

    // Prints the n-ary tree level wise
    static void LevelOrderTraversal(Node root)
    {
        if (root == null)
            return;

        // Standard level order traversal code
        // using queue
        Queue<Node > q = new LinkedList<>(); // Create a queue
        q.add(root); // Enqueue root
        while (!q.isEmpty())
        {
            int n = q.size();

            // If this node has children
            while (n > 0)
            {
                // Dequeue an item from queue
                // and print it
                Node p = q.peek();
                q.remove();
                System.out.print(p.key + " ");

                // Enqueue all children of
                // the dequeued item
                for (int i = 0; i < p.child.size(); i++)
                    q.add(p.child.get(i));
                n--;
            }

            // Print new line between two levels
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        /* Let us create below tree
         *	      10
         *	 /  /    \   \
         *	 2 34   56  100
         *	/ \     |   / | \
         * 77 88	1   7 8 9
         */
        Node root = newNode(10);
        (root.child).add(newNode(2));
        (root.child).add(newNode(34));
        (root.child).add(newNode(56));
        (root.child).add(newNode(100));
        (root.child.get(0).child).add(newNode(77));
        (root.child.get(0).child).add(newNode(88));
        (root.child.get(2).child).add(newNode(1));
        (root.child.get(3).child).add(newNode(7));
        (root.child.get(3).child).add(newNode(8));
        (root.child.get(3).child).add(newNode(9));

        System.out.println("Level order traversal " +
                "Before Mirroring ");
        LevelOrderTraversal(root);
    }
}
