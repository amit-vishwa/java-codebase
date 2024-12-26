package tutorial.dsa.datastructures.trees.balancewise;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-red-black-tree/
 *
 * Binary search trees are a fundamental data structure, but their performance can suffer if the tree becomes
 * unbalanced. Red Black Trees are a type of balanced binary search tree that use a set of rules to maintain balance,
 * ensuring logarithmic time complexity for operations like insertion, deletion, and searching, regardless of the
 * initial shape of the tree. Red Black Trees are self-balancing, using a simple color-coding scheme to adjust
 * the tree after each modification.
 *
 * What is a Red-Black Tree?
 * A Red-Black Tree is a self-balancing binary search tree where each node has an additional attribute: a color,
 * which can be either red or black. The primary objective of these trees is to maintain balance during insertions
 * and deletions, ensuring efficient data retrieval and manipulation.
 *
 * Properties of Red-Black Trees
 * A Red-Black Tree have the following properties:
 * i.Node Color: Each node is either red or black.
 * ii.Root Property: The root of the tree is always black.
 * iii.Red Property: Red nodes cannot have red children (no two consecutive red nodes on any path).
 * iv.Black Property: Every path from a node to its descendant null nodes (leaves) has the same number of black nodes.
 * v.Leaf Property: All leaves (NIL nodes) are black.
 *
 * Basic Operations on Red-Black Tree:
 * The basic operations on a Red-Black Tree include:
 * - Insertion
 * - Search
 * - Deletion
 * - Rotation
 *
 * Time complexity:
 * 1.   Search	O(log n)
 * 2.	Insert	O(log n)
 * 3.	Delete	O(log n)
 * */
public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private static class Node {
        int key;
        Node left, right, parent;
        boolean color;

        Node(int key) {
            this.key = key;
            this.color = RED;
        }
    }

    public void insert(int key) {
        Node node = new Node(key);
        root = insertRec(root, node);
        fixInsert(node);
    }

    private Node insertRec(Node root, Node node) {
        if (root == null) {
            return node;
        }
        if (node.key < root.key) {
            root.left = insertRec(root.left, node);
            root.left.parent = root;
        } else if (node.key > root.key) {
            root.right = insertRec(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixInsert(Node node) {
        Node parent = null;
        Node grandParent = null;
        while (node != root && node.color != BLACK && node.parent.color == RED) {
            parent = node.parent;
            grandParent = parent.parent;
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateRight(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }
                    rotateLeft(grandParent);
                    boolean tempColor = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = tempColor;
                    node = parent;
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (node.right != null) {
            node.right.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (node.left != null) {
            node.left.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.left) {
            node.parent.left = leftChild;
        } else {
            node.parent.right = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    private Node searchRec(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (key < root.key) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public void delete(int key) {
        Node node = searchRec(root, key);
        if (node == null) {
            return;
        }
        deleteNode(node);
    }

    private void deleteNode(Node node) {
        Node replacement = node;
        Node child;
        boolean originalColor = replacement.color;

        if (node.left == null) {
            child = node.right;
            transplant(node, node.right);
        } else if (node.right == null) {
            child = node.left;
            transplant(node, node.left);
        } else {
            replacement = minimum(node.right);
            originalColor = replacement.color;
            child = replacement.right;
            if (replacement.parent == node) {
                if (child != null) {
                    child.parent = replacement;
                }
            } else {
                transplant(replacement, replacement.right);
                replacement.right = node.right;
                replacement.right.parent = replacement;
            }
            transplant(node, replacement);
            replacement.left = node.left;
            replacement.left.parent = replacement;
            replacement.color = node.color;
        }

        if (originalColor == BLACK) {
            fixDelete(child);
        }
    }

    private void transplant(Node target, Node with) {
        if (target.parent == null) {
            root = with;
        } else if (target == target.parent.left) {
            target.parent.left = with;
        } else {
            target.parent.right = with;
        }
        if (with != null) {
            with.parent = target.parent;
        }
    }

    private void fixDelete(Node node) {
        while (node != root && getColor(node) == BLACK) {
            if (node == node.parent.left) {
                Node sibling = node.parent.right;
                if (getColor(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(node.parent, RED);
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }
                if (getColor(sibling.left) == BLACK && getColor(sibling.right) == BLACK) {
                    setColor(sibling, RED);
                    node = node.parent;
                } else {
                    if (getColor(sibling.right) == BLACK) {
                        setColor(sibling.left, BLACK);
                        setColor(sibling, RED);
                        rotateRight(sibling);
                        sibling = node.parent.right;
                    }
                    setColor(sibling, getColor(node.parent));
                    setColor(node.parent, BLACK);
                    setColor(sibling.right, BLACK);
                    rotateLeft(node.parent);
                    node = root;
                }
            } else {
                Node sibling = node.parent.left;
                if (getColor(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(node.parent, RED);
                    rotateRight(node.parent);
                    sibling = node.parent.left;
                }
                if (getColor(sibling.left) == BLACK && getColor(sibling.right) == BLACK) {
                    setColor(sibling, RED);
                    node = node.parent;
                } else {
                    if (getColor(sibling.left) == BLACK) {
                        setColor(sibling.right, BLACK);
                        setColor(sibling, RED);
                        rotateLeft(sibling);
                        sibling = node.parent.left;
                    }
                    setColor(sibling, getColor(node.parent));
                    setColor(node.parent, BLACK);
                    setColor(sibling.left, BLACK);
                    rotateRight(node.parent);
                    node = root;
                }
            }
        }
        setColor(node, BLACK);
    }

    private Node minimum(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private boolean getColor(Node node) {
        return node == null ? BLACK : node.color;
    }

    private void setColor(Node node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);

        System.out.println("In-order traversal of the RedBlackTree:");
        tree.inOrderTraversal();

        System.out.println("Deleting key 15");
        tree.delete(10);
        System.out.println("In-order traversal after deletion:");
        tree.inOrderTraversal();
    }
}