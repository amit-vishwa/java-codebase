package tutorial.dsa.datastructures.trees.degreewise.binarytreeoperations;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-binary-tree/
 *
 * 3. Searching in Binary Tree
 * Searching for a value in a binary tree means looking through the tree to find a node that has that value.
 * Since binary trees do not have a specific order like binary search trees, we typically use any traversal method to
 * search. The most common methods are depth-first search (DFS) and breadth-first search (BFS). In DFS, we start from
 * the root and explore the depth nodes first. In BFS, we explore all the nodes at the present depth level before
 * moving on to the nodes at the next level. We continue this process until we either find the node with the desired
 * value or reach the end of the tree. If the tree is empty or the value isn’t found after exploring all possibilities,
 * we conclude that the value does not exist in the tree.
 *
 * */
public class BinaryTreeSearch {

    public static void main(String[] args){
        BTNode root = new BTNode(2);
        root.left = new BTNode(3);
        root.right = new BTNode(4);
        root.left.left = new BTNode(5);
        root.left.right = new BTNode(6);

        int value = 6;
        if (searchDFS(root, value))
            System.out.println(
                    value + " is found in the binary tree");
        else
            System.out.println(
                    value + " is not found in the binary tree");
    }

    // Function to search for a value in the binary tree
    // using DFS
    static boolean searchDFS(BTNode root, int value){
        // Base case: If the tree is empty or we've reached
        // a leaf node
        if (root == null) return false;

        // If the node's data is equal to the value we are
        // searching for
        if (root.data == value) return true;

        // Recursively search in the left and right subtrees
        boolean left_res = searchDFS(root.left, value);
        boolean right_res = searchDFS(root.right, value);

        return left_res || right_res;
    }
}
