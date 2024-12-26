package tutorial.dsa.datastructures.trees.balancewise;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-avl-tree/
 *
 * An AVL tree defined as a self-balancing Binary Search Tree (BST) where the difference between heights of left
 * and right subtrees for any node cannot be more than one.
 * The difference between the heights of the left subtree and the right subtree for any node is known as the balance
 * factor of the node.
 * The AVL tree is named after its inventors, Georgy Adelson-Velsky and Evgenii Landis, who published it in their
 * 1962 paper “An algorithm for the organization of information”.
 *
 * Operations on an AVL Tree:
 * Insertion
 * Deletion
 * Searching [It is similar to performing a search in BST]
 * */
public class AVLTree {

    public static void main(String[] args) {
        Node root = null;

        // Constructing tree given in the above figure
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /* The constructed AVL Tree would be
                  30
                /   \
              20     40
             /  \      \
           10   25     50
        */
        System.out.println("Preorder traversal : ");
        preOrder(root);

        System.out.print("\nIs 20 present in tree: " + avlSearch(root, 20));

        root = deleteNode(root, 20);

        System.out.println("\nPreorder traversal after"
                + " deletion of 20:");
        preOrder(root);

        System.out.print("\nIs 20 present in tree: " + avlSearch(root, 20));
    }

    // A utility function to get the
    // height of the tree
    static int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // A utility function to right rotate
    // subtree rooted with y
    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left),
                height(y.right));
        x.height = 1 + Math.max(height(x.left),
                height(x.right));

        // Return new root
        return x;
    }

    // A utility function to left rotate
    // subtree rooted with x
    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left),
                height(x.right));
        y.height = 1 + Math.max(height(y.left),
                height(y.right));

        // Return new root
        return y;
    }

    // Get balance factor of node N
    static int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    /**
     * 1.Insertion
     * Refer: https://www.geeksforgeeks.org/insertion-in-an-avl-tree/
     *
     * Follow the steps mentioned below to implement the idea:
     * - Perform the normal BST insertion.
     * - The current node must be one of the ancestors of the newly inserted node. Update the height of the current node.
     * - Get the balance factor (left subtree height – right subtree height) of the current node.
     * - If the balance factor is greater than 1, then the current node is unbalanced and we are either in the Left Left
     * case or left Right case. To check whether it is left left case or not, compare the newly inserted key with the
     * key in the left subtree root.
     * - If the balance factor is less than -1, then the current node is unbalanced and we are either in the
     * Right Right case or Right-Left case. To check whether it is the Right Right case or not, compare the
     * newly inserted key with the key in the right subtree root.
     * */
    static Node insert(Node node, int key) {

        // Perform the normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Equal keys are not allowed in BST
            return node;

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left),
                height(node.right));

        // Get the balance factor of this ancestor node
        int balance = getBalance(node);

        // If this node becomes unbalanced,
        // then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // A utility function to print preorder
    // traversal of the tree
    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 2.Deletion
     * Refer: https://www.geeksforgeeks.org/deletion-in-an-avl-tree/?ref=lbp
     *
     * Following is the implementation for AVL Tree Deletion. The following implementation uses the recursive BST
     * delete as basis. In the recursive BST delete, after deletion, we get pointers to all ancestors one by one
     * in bottom up manner. So we don’t need parent pointer (or reference) to travel up. The recursive code itself
     * travels up and visits all the ancestors of the deleted node.
     *
     * i.Perform the normal BST deletion.
     * ii.The current node must be one of the ancestors of the deleted node. Update the height of the current node.
     * iii.Get the balance factor (left subtree height – right subtree height) of the current node.
     * iv.If balance factor is greater than 1, then the current node is unbalanced and we are either in Left Left
     * case or Left Right case. To check whether it is Left Left case or Left Right case, get the balance factor
     * of left subtree. If balance factor of the left subtree is greater than or equal to 0, then it is Left Left
     * case, else Left Right case.
     * v.If balance factor is less than -1, then the current node is unbalanced and we are either in Right Right case
     * or Right Left case. To check whether it is Right Right case or Right Left case, get the balance factor of right
     * subtree. If the balance factor of the right subtree is smaller than or equal to 0, then it is Right Right case,
     * else Right Left case.
     * */
    static Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller
        // than the root's key, then it lies in
        // left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater
            // than the root's key, then it lies in
            // right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then
            // this is the node to be deleted
        else {
            // node with only one child or no child
            if ((root.left == null) ||
                    (root.right == null)) {
                Node temp = root.left != null ?
                        root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            } else {
                // node with two children: Get the
                // inorder successor (smallest in
                // the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's
                // data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left),
                height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS
        // NODE (to check whether this node
        // became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then
        // there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    // Given a non-empty binary search tree,
    // return the node with minimum key value
    // found in that tree.
    static Node minValueNode(Node node) {
        Node current = node;

        // loop down to find the leftmost leaf
        while (current.left != null)
            current = current.left;

        return current;
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    // 3.Search (Similar to BST search)
    public static boolean avlSearch(Node root, int key) {
        if (root == null)
            return false;
        else if (root.key == key)
            return true;
        else if (root.key > key)
            return avlSearch(root.left, key);
        else
            return avlSearch(root.right, key);
    }

}

class Node {
    int key;
    Node left;
    Node right;
    int height;

    Node(int k) {
        key = k;
        left = null;
        right = null;
        height = 1;
    }
}