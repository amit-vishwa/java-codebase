package tutorial.dsa.datastructures.trees;

import java.util.ArrayList;

/**
 * Refer: https://www.geeksforgeeks.org/introduction-to-tree-data-structure/
 *
 * Tree data structure is a hierarchical structure that is used to represent and organize data in a way that is easy
 * to navigate and search. It is a collection of nodes that are connected by edges and has a hierarchical relationship
 * between the nodes.
 *
 * The topmost node of the tree is called the root, and the nodes below it are called the child nodes. Each node
 * can have multiple child nodes, and these child nodes can also have their own child nodes, forming a recursive
 * structure.
 *
 * Basic Terminologies In Tree Data Structure:
 * - Parent Node: The node which is an immediate predecessor of a node is called the parent node of that node. {B} is the parent node of {D, E}.
 * - Child Node: The node which is the immediate successor of a node is called the child node of that node. Examples: {D, E} are the child nodes of {B}.
 * - Root Node: The topmost node of a tree or the node which does not have any parent node is called the root node. {A} is the root node of the tree. A non-empty tree must contain exactly one root node and exactly one path from the root to all other nodes of the tree.
 * - Leaf Node or External Node: The nodes which do not have any child nodes are called leaf nodes. {I, J, K, F, G, H} are the leaf nodes of the tree.
 * - Ancestor of a Node: Any predecessor nodes on the path of the root to that node are called Ancestors of that node. {A,B} are the ancestor nodes of the node {E}
 * - Descendant: A node x is a descendant of another node y if and only if y is an ancestor of x.
 * - Sibling: Children of the same parent node are called siblings. {D,E} are called siblings.
 * - Level of a node: The count of edges on the path from the root node to that node. The root node has level 0.
 * - Internal node: A node with at least one child is called Internal Node.
 * - Neighbour of a Node: Parent or child nodes of that node are called neighbors of that node.
 * - Subtree: Any node of the tree along with its descendant.
 *
 * Importance for Tree Data Structure:
 * One reason to use trees might be because you want to store information that naturally forms a hierarchy.
 * For example, the file system on a computer: The DOM model of an HTML page is also tree where we have html tag
 * as root, head and body its children and these tags, then have their own children.
 *
 * Types of Tree data structures:
 * Tree data structure can be classified into three types based upon the number of children each node of the
 * tree can have. The types are:
 * i.Binary tree: In a binary tree, each node can have a maximum of two children linked to it. Some common types of binary trees include full binary trees, complete binary trees, balanced binary trees, and degenerate or pathological binary trees. Examples of Binary Tree are Binary Search Tree and Binary Heap.
 * ii.Ternary Tree: A Ternary Tree is a tree data structure in which each node has at most three child nodes, usually distinguished as “left”, “mid” and “right”.
 * iii.N-ary Tree or Generic Tree: Generic trees are a collection of nodes where each node is a data structure that consists of records and a list of references to its children(duplicate references are not allowed). Unlike the linked list, each node stores the address of multiple nodes.
 *
 * Basic Operations Of Tree Data Structure:
 * i.Create – create a tree in the data structure.
 * ii.Insert − Inserts data in a tree.
 * iii.Search − Searches specific data in a tree to check whether it is present or not.
 * iv.Traversal:
 * Depth-First-Search Traversal
 * Breadth-First-Search Traversal
 *
 * Properties of Tree Data Structure:
 * - Number of edges: An edge can be defined as the connection between two nodes. If a tree has N nodes then it will have (N-1) edges. There is only one path from each node to any other node of the tree.
 * - Depth of a node: The depth of a node is defined as the length of the path from the root to that node. Each edge adds 1 unit of length to the path. So, it can also be defined as the number of edges in the path from the root of the tree to the node.
 * - Height of a node: The height of a node can be defined as the length of the longest path from the node to a leaf node of the tree.
 * - Height of the Tree: The height of a tree is the length of the longest path from the root of the tree to a leaf node of the tree.
 * - Degree of a Node: The total count of subtrees attached to that node is called the degree of the node. The degree of a leaf node must be 0. The degree of a tree is the maximum degree of a node among all the nodes in the tree.
 * */
public class TreeDataStructure {

    public static void main(String[] args)
    {
        // Number of nodes
        int N = 7, Root = 1;

        // Adjacency list to store the tree
        ArrayList<ArrayList<Integer>> tree
                = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N + 1; i++) {
            tree.add(new ArrayList<Integer>());
        }
        // Creating the tree
        tree.get(1).add(2);
        tree.get(2).add(1);

        tree.get(1).add(3);
        tree.get(3).add(1);

        tree.get(1).add(4);
        tree.get(4).add(1);

        tree.get(2).add(5);
        tree.get(5).add(2);

        tree.get(2).add(6);
        tree.get(6).add(2);

        tree.get(4).add(7);
        tree.get(7).add(4);

        // Printing the parents of each node
        System.out.println("The parents of each node are:");
        printParents(Root, tree, 0);

        // Printing the children of each node
        System.out.println(
                "\nThe children of each node are:");
        printChildren(Root, tree);

        // Printing the leaf nodes in the tree
        System.out.println(
                "\nThe leaf nodes of the tree are:");
        printLeafNodes(Root, tree);

        // Printing the degrees of each node
        System.out.println("\nThe degrees of each node are:");
        printDegrees(Root, tree);
    }

    // Prints parent node of current node
    private static void printParents(int node, ArrayList<ArrayList<Integer>> tree, int parent) {
        // If parent is 0 then node is child of root
        if(parent == 0){
            System.out.println("Node: " + node + ", Parent: Root");
        }else{
            // Else print node and it's parent
            System.out.println("Node: " + node + ", Parent: " + parent);
        }
        // Iterate over child of node using Depth First Search (DFS)
        for(int i = 0; i < tree.get(node).size(); i++){
            // If child is not parent then make recursive call
            if(tree.get(node).get(i) != parent){
                // Here child is now new parent and new node is passed
                printParents(tree.get(node).get(i), tree, node);
            }
        }
    }

    // Prints child nodes of current node
    private static void printChildren(int root, ArrayList<ArrayList<Integer>> tree) {
        // List to store visited nodes
        ArrayList<Integer> visitedNode = new ArrayList<>();
        // Iterate over the tree starting from root
        for(int i = root; i < tree.size(); i++){
            // Add current node to visited list
            visitedNode.add(i);
            // Print node
            System.out.print("Node: " + i + ", Children: ");
            // Iterate over the node children
            for(int j = 0; j < tree.get(i).size(); j++){
                // If children are there and child node is not the visited one
                if(!tree.get(i).isEmpty() && !visitedNode.contains(tree.get(i).get(j))){
                    // Print children of current node
                    System.out.print(tree.get(i).get(j)+" ");
                }
            }
            System.out.println();
        }
    }

    // Prints leaf or external node if only one child node is there
    private static void printLeafNodes(int root, ArrayList<ArrayList<Integer>> tree) {
        // Iterate over the tree
        for(int i = root; i < tree.size(); i++){
            // If current node is only linked with a single node, then it is a leaf node
            if(tree.get(i).size() == 1){
                // Print leaf node of current node
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // Print degree i.e. child node count, of the node
    private static void printDegrees(int root, ArrayList<ArrayList<Integer>> tree) {
        // List to store visited nodes
        ArrayList<Integer> visitedNode = new ArrayList<>();
        // Iterate over the tree starting from root
        for(int i = root; i < tree.size(); i++){
            // Add current node to visited list
            visitedNode.add(i);
            // Print node
            System.out.print("Node: " + i + ", Degree: ");
            // Initialize degree to 0
            int degree = 0;
            // Iterate over the node children
            for(int j = 0; j < tree.get(i).size(); j++){
                // If children are there and child node is not the visited one
                if(!tree.get(i).isEmpty() && !visitedNode.contains(tree.get(i).get(j))){
                    // Increase the degree of the node by 1
                    degree++;
                }
            }
            // Print the node degree
            System.out.println(degree);
        }
    }

}
