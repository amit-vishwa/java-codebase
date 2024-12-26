package tutorial.dsa.datastructures.trees.degreewise.binarytreeoperations;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-binary-tree/
 *
 * 2. Insertion in Binary Tree
 * Inserting elements means add a new node into the binary tree. As we know that there is no such ordering of elements
 * in the binary tree, So we do not have to worry about the ordering of node in the binary tree. We would first creates
 * a root node in case of empty tree. Then subsequent insertions involve iteratively searching for an empty place at
 * each level of the tree. When an empty left or right child is found then new node is inserted there. By convention,
 * insertion always starts with the left child node.
 * */
public class BinaryTreeInsertion {

    public static void main(String[] args) {
        BTNode root = new BTNode(2);
        root.left = new BTNode(3);
        root.right = new BTNode(4);
        root.left.left = new BTNode(5);

        System.out.print("Inorder traversal before insertion: ");
        inorder(root);
        System.out.println();

        int key = 6;
        root = insert(root, key);

        System.out.print("Inorder traversal after insertion: ");
        inorder(root);
        System.out.println();
    }

    // Function to insert a new node in the binary tree
    static BTNode insert(BTNode root, int key) {
        if (root == null) return new BTNode(key);

        // Create a queue for level order traversal
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BTNode temp = q.poll();

            // If left child is empty, insert the new node here
            if (temp.left == null) {
                temp.left = new BTNode(key);
                break;
            } else {
                q.add(temp.left);
            }

            // If right child is empty, insert the new node here
            if (temp.right == null) {
                temp.right = new BTNode(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
        return root;
    }

    // In-order traversal
    static void inorder(BTNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}