package tutorial.dsa.datastructures.trees.degreewise.binarytreeoperations;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-binary-tree/
 *
 * 4. Deletion in Binary Tree
 * Deleting a node from a binary tree means removing a specific node while keeping the tree’s structure. First, we need
 * to find the node that want to delete by traversing through the tree using any traversal method. Then replace the
 * node’s value with the value of the last node in the tree (found by traversing to the rightmost leaf), and then
 * delete that last node. This way, the tree structure won’t be effected. And remember to check for special cases,
 * like trying to delete from an empty tree, to avoid any issues.
 *
 * Note: There is no specific rule of deletion but we always make sure that during deletion the proper binary tree
 * should be preserved.
 * */
public class BinaryTreeDeletion {

    public static void main(String[] args) {
        BTNode root = new BTNode(2);
        root.left = new BTNode(3);
        root.right = new BTNode(4);
        root.left.left = new BTNode(5);
        root.left.right = new BTNode(6);

        System.out.print("Original tree (in-order): ");
        inorder(root);
        System.out.println();

        int valToDel = 3;
        root = deleteNode(root, valToDel);

        System.out.print("Tree after deleting " + valToDel + " (in-order): ");
        inorder(root);
        System.out.println();
    }

    // In-order traversal
    static void inorder(BTNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Function to delete a node from the binary tree
    static BTNode deleteNode(BTNode root, int val) {
        if (root == null) return null;

        // Use a queue to perform BFS
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        BTNode target = null;

        // Find the target node
        while (!q.isEmpty()) {
            BTNode curr = q.poll();

            if (curr.data == val) {
                target = curr;
                break;
            }
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        if (target == null) return root;

        // Find the deepest rightmost node and its parent
        BTNode lastNode = null;
        BTNode lastParent = null;
        Queue<BTNode> q1 = new LinkedList<>();
        Queue<BTNode> parentQueue = new LinkedList<>();
        q1.add(root);
        parentQueue.add(null);

        while (!q1.isEmpty()) {
            BTNode curr = q1.poll();
            BTNode parent = parentQueue.poll();

            lastNode = curr;
            lastParent = parent;

            if (curr.left != null) {
                q1.add(curr.left);
                parentQueue.add(curr);
            }
            if (curr.right != null) {
                q1.add(curr.right);
                parentQueue.add(curr);
            }
        }

        // Replace target's value with the last node's value
        target.data = lastNode.data;

        // Remove the last node
        if (lastParent != null) {
            if (lastParent.left == lastNode) lastParent.left = null;
            else lastParent.right = null;
        } else {
            return null;
        }
        return root;
    }

}
