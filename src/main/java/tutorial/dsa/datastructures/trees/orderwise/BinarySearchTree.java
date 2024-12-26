package tutorial.dsa.datastructures.trees.orderwise;

/**
 * Refer: https://www.geeksforgeeks.org/binary-search-tree-data-structure/
 *
 * A Binary Search Tree (or BST) is a data structure used in computer science for organizing and storing data in a
 * sorted manner. Each node in a Binary Search Tree has at most two children, a left child and a right child, with
 * the left child containing values less than the parent node and the right child containing values greater than the
 * parent node. This hierarchical structure allows for efficient searching, insertion, and deletion operations on the
 * data stored in the tree.
 *
 * */
public class BinarySearchTree {

    public static void main(String[] args)
    {
        Node root = null;

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        // Print inorder traversal of the BST
        inorder(root);
        System.out.println();

        // Searching for keys in the BST
        System.out.println(search(root, 19)
                ? "Found"
                : "Not Found");
        System.out.println(search(root, 80)
                ? "Found"
                : "Not Found");

        // Deleting the key from the BST
        root = delNode(root, 70);
        inorder(root);
    }

    /**
     * 1.Insertion
     * Refer: https://www.geeksforgeeks.org/insertion-in-binary-search-tree/?ref=lbp
     *
     * How to Insert a value in a Binary Search Tree:
     * A new key is always inserted at the leaf by maintaining the property of the binary search tree.
     * We start searching for a key from the root until we hit a leaf node. Once a leaf node is found,
     * the new node is added as a child of the leaf node. The below steps are followed while we try to insert
     * a node into a binary search tree:
     * - Initialize the current node (say, currNode or node) with root node
     * - Compare the key with the current node.
     * - Move left if the key is less than or equal to the current node value.
     * - Move right if the key is greater than current node value.
     * - Repeat steps 2 and 3 until you reach a leaf node.
     * - Attach the new key as a left or right child based on the comparison with the leaf node’s value.
     *
     * Time Complexity:
     * The worst-case time complexity of insert operations is O(h) where h is the height of the Binary Search Tree.
     * In the worst case, we may have to travel from the root to the deepest leaf node. The height of a skewed tree may become n and the time complexity of insertion operation may become O(n).
     *
     * Auxiliary Space: The auxiliary space complexity of insertion into a binary search tree is O(1)
     * */
    static Node insert(Node root, int key)
    {

        // If the tree is empty, return a new node
        if (root == null)
            return new Node(key);

        // If the key is already present in the tree,
        // return the node
        if (root.key == key)
            return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // A utility function to do inorder tree traversal
    static void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    /**
     * 2.Search
     * Refer: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/?ref=lbp
     *
     * Algorithm to search for a key in a given Binary Search Tree:
     * Let’s say we want to search for the number X, We start at the root. Then:
     * - We compare the value to be searched with the value of the root.
     * If it’s equal we are done with the search if it’s smaller we know that we need to go to the left subtree
     * because in a binary search tree all the elements in the left subtree are smaller and all the elements
     * in the right subtree are larger.
     * - Repeat the above step till no more traversal is possible
     * - If at any iteration, key is found, return True. Else False.
     *
     * Time complexity: O(h), where h is the height of the BST.
     * Auxiliary Space: O(h) This is because of the space needed to store the recursion stack.
     * */
    private static boolean search(Node root, int i) {
        if(root == null){
            return false;
        }
        if(root.key == i){
            return true;
        }
        if(root.key > i){
            return search(root.left, i);
        }
        else{
            return search(root.right, i);
        }
        // Below is iterative approach
        /*Node temp = root;
        while (temp!=null){
            if(temp.key == i){
                return true;
            }
            if(temp.key>i){
                temp = temp.left;
            }
            else{
                temp = temp.right;
            }
        }
        return false;*/
    }

    /**
     * 3.Deletion
     * Refer: https://www.geeksforgeeks.org/deletion-in-binary-search-tree/?ref=lbp,
     * https://www.geeksforgeeks.org/optimized-recursive-delete-in-bst/
     *
     * Case 1. Delete a Leaf Node in BST
     * Case 2. Delete a Node with Single Child in BST
     * - Deleting a single child node is also simple in BST. Copy the child to the node and delete the node.
     * Case 3. Delete a Node with Both Children in BST
     * - Deleting a node with both children is not so simple. Here we have to delete the node is such a way,
     * that the resulting tree follows the properties of a BST.
     * - The trick is to find the inorder successor of the node. Copy contents of the inorder successor to the node,
     * and delete the inorder successor.
     * Note: Inorder predecessor can also be used.
     * Note: Inorder successor is needed only when the right child is not empty. In this particular case, the inorder
     * successor can be obtained by finding the minimum value in the right child of the node.
     *
     * Time Complexity: O(h), where h is the height of the BST.
     * Auxiliary Space: O(h).
     * */
    static Node delNode(Node root, int k) {
        // Base case
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than
        // the root's key, then it lies in the left
        // subtree
        if (k < root.key) {
            root.left = delNode(root.left, k);
            return root;
        }

        // If the key to be deleted is greater
        // than the root's key, then it lies in
        // the right subtree
        else if (k > root.key) {
            root.right = delNode(root.right, k);
            return root;
        }

        // If key is same as root's key, then this
        // is the node to be deleted
        // Node with only one child or no child
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // Node with two children: Get the inorder
        // successor (smallest in the right subtree).
        // Also find parent of the successor
        Node succParent = root;
        Node succ = root.right;
        while (succ.left != null) {
            succParent = succ;
            succ = succ.left;
        }

        // Copy the inorder successor's content
        // to this node
        root.key = succ.key;

        // Delete the inorder successor
        if (succParent.left == succ) {
            succParent.left = succ.right;
        } else {
            succParent.right = succ.right;
        }

        return root;
    }

}

class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}