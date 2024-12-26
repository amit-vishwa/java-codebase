package tutorial.dsa.datastructures.trees.degreewise;

/**
 * Refer: https://www.geeksforgeeks.org/what-is-ternary-tree/?ref=lbp, https://www.geeksforgeeks.org/ternary-search-tree/
 *
 * A Ternary Tree is a special type of tree data structure. Unlike a regular binary tree where each node can have up
 * to two child nodes. The article explains the basic structure and properties of ternary trees, such as the number
 * of possible children per node, tree height, and node depth. It also discusses why ternary trees can be useful,
 * highlighting applications in areas like string searching and database indexing. It also introduces some common
 * problems and algorithms related to ternary trees.
 *
 * Properties of Ternary Trees
 * Children Count: Each node in a ternary tree can have zero, one, two, or three children.
 * Height: The height of a ternary tree is the length of the longest path from the root to a leaf. A leaf is a node with no children.
 * Depth: The depth of a node is the number of edges from the root to the node.
 *
 * Why Use a Ternary Tree?
 * Ternary trees are useful in specific scenarios where more than two children per node are beneficial.
 * Here are some common applications:
 * i.Ternary Search Trees: These are specialized ternary trees used for storing and searching strings. They combine the
 * advantages of binary search trees and digital search tries, making them efficient for certain types of string search operations.
 * ii.Multi-way Trees: In databases and file systems, multi-way trees (like B-trees) generalize ternary trees to have more
 * than three children, but the concept starts with understanding ternary trees.
 *
 * Basic Operations on a Ternary Tree
 * i.Insertion: Adding a new node to the tree.
 * ii.Deletion: Removing a node from the tree.
 * iii.Traversal: Visiting all the nodes in the tree in a specific order. Common traversal methods include:
 * - Pre-order Traversal: Visit the root, then recursively visit the left, middle, and right subtrees.
 * - In-order Traversal: Recursively visit the left subtree, visit the root, then the middle subtree, and finally the right subtree.
 * - Post-order Traversal: Recursively visit the left, middle, and right subtrees, then visit the root.
 * */
public class TernaryTree {

    public static void main(String[] args)
    {
        TNode root = new TNode(' ');
        root = insert(root, "cat");
        root = insert(root, "cats");
        root = insert(root, "up");
        root = insert(root, "bug");

        System.out.println(
                "Following is traversal of ternary search tree:");
        traverseTST(root);

        System.out.println(
                "\nFollowing are search results for 'cats', 'bu', and 'up':");
        System.out.println(searchTST(root, "cats")
                ? "Found"
                : "Not Found");
        System.out.println(
                searchTST(root, "bu") ? "Found" : "Not Found");
        System.out.println(
                searchTST(root, "up") ? "Found" : "Not Found");
    }

    public static TNode insert(TNode root, String word)
    {
        if (root == null) {
            root = new TNode(word.charAt(0));
        }
        if (word.charAt(0) < root.data) {
            root.left = insert(root.left, word);
        }
        else if (word.charAt(0) > root.data) {
            root.right = insert(root.right, word);
        }
        else {
            if (word.length() > 1) {
                root.eq
                        = insert(root.eq, word.substring(1));
            }
            else {
                root.isEndOfString = true;
            }
        }
        return root;
    }

    public static void
    traverseTSTUtil(TNode root, char[] buffer, int depth)
    {
        if (root != null) {
            traverseTSTUtil(root.left, buffer, depth);
            buffer[depth] = root.data;
            if (root.isEndOfString) {
                System.out.println(
                        new String(buffer, 0, depth + 1));
            }
            traverseTSTUtil(root.eq, buffer, depth + 1);
            traverseTSTUtil(root.right, buffer, depth);
        }
    }

    public static void traverseTST(TNode root)
    {
        char[] buffer = new char[50];
        traverseTSTUtil(root, buffer, 0);
    }

    public static boolean searchTST(TNode root, String word)
    {
        if (root == null) {
            return false;
        }
        if (word.charAt(0) < root.data) {
            return searchTST(root.left, word);
        }
        else if (word.charAt(0) > root.data) {
            return searchTST(root.right, word);
        }
        else {
            if (word.length() > 1) {
                return searchTST(root.eq,
                        word.substring(1));
            }
            else {
                return root.isEndOfString;
            }
        }
    }

}

class TNode {
    char data;
    boolean isEndOfString;
    TNode left, eq, right;

    public TNode(char data)
    {
        this.data = data;
        this.isEndOfString = false;
        this.left = null;
        this.eq = null;
        this.right = null;
    }
}

