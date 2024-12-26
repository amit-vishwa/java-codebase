package tutorial.dsa.datastructures.trees.degreewise;

/**
 * Refer: https://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * A Binary Tree Data Structure is a hierarchical data structure in which each node has at most two children,
 * referred to as the left child and the right child. It is commonly used in computer science for efficient storage
 * and retrieval of data, with various operations such as insertion, deletion, and traversal.
 *
 * Binary Tree is a non-linear and hierarchical data structure where each node has at most two children referred to as
 * the left child and the right child.  The topmost node in a binary tree is called the root, and the bottom-most
 * nodes are called leaves.
 *
 * Terminologies in Binary Tree
 * - Nodes: The fundamental part of a binary tree, where each node contains data and link to two child nodes.
 * - Root: The topmost node in a tree is known as the root node. It has no parent and serves as the starting point for all nodes in the tree.
 * - Parent Node: A node that has one or more child nodes. In a binary tree, each node can have at most two children.
 * - Child Node: A node that is a descendant of another node (its parent).
 * - Leaf Node: A node that does not have any children or both children are null.
 * - Internal Node: A node that has at least one child. This includes all nodes except the root and the leaf nodes.
 * - Depth of a Node: The number of edges from a specific node to the root node. The depth of the root node is zero.
 * - Height of a Binary Tree: The number of nodes from the deepest leaf node to the root node.
 *
 * Properties of Binary Tree
 * The maximum number of nodes at level L of a binary tree is 2L
 * The maximum number of nodes in a binary tree of height H is 2H – 1
 * Total number of leaf nodes in a binary tree = total number of nodes with 2 children + 1
 * In a Binary Tree with N nodes, the minimum possible height or the minimum number of levels is Log2(N+1)
 * A Binary Tree with L leaves has at least | Log2L |+ 1 levels
 *
 * Complexity Analysis of Binary Tree Operations
 * Here’s the complexity analysis for specific binary tree operations:
 * Operations           Time Complexity     Space Complexity
 * In-Order Traversal	    O(n)            	O(n)
 * Pre-Order Traversal	    O(n)	            O(n)
 * Post-Order Traversal 	O(n)	            O(n)
 * Insertion (Unbalanced)	O(n)	            O(n)
 * Searching (Unbalanced)	O(n)	            O(n)
 * Deletion (Unbalanced)	O(n)	            O(n)
 *
 * */
public class BinaryTree {

    public static void main(String[] args) {
        // Initialize and allocate memory for tree nodes
        Node firstNode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);

        // Connect binary tree nodes
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;

        System.out.println("Node1 -> Data: " + firstNode.data + ", Left: " + firstNode.left + ", Right: " + firstNode.right);
        System.out.println("Node2 -> Data: " + secondNode.data + ", Left: " + secondNode.left + ", Right: " + secondNode.right);
        System.out.println("Node3 -> Data: " + thirdNode.data + ", Left: " + thirdNode.left + ", Right: " + thirdNode.right);
        System.out.println("Node4 -> Data: " + fourthNode.data + ", Left: " + fourthNode.left + ", Right: " + fourthNode.right);
    }

}

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}
