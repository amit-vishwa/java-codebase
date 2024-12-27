package tutorial.dsa.datastructures.graphs.unweighted;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Refer: https://www.geeksforgeeks.org/graph-and-its-representations/
 *
 * Comparison between Adjacency Matrix and Adjacency List
 * When the graph contains a large number of edges then it is good to store it as a matrix because only some entries
 * in the matrix will be empty. An algorithm such as Prim’s and Dijkstra adjacency matrix is used to have less complexity.
 *
 * Action           Adjacency Matrix    Adjacency List
 * Adding Edge	           O(1)        	    O(1)
 * Removing an edge	       O(1)         	O(N)
 * Initializing	           O(N*N)       	O(N)
 *
 * 1.What are the different types of Graph Data Structure?
 * Graph Data Structure can be classified into various types based on properties such as directionality of edges
 * (directed or undirected), presence of cycles (acyclic or cyclic), and whether multiple edges between the same pair
 * of vertices are allowed (simple or multigraph).
 *
 * 2.What is the difference between a directed graph and an undirected graph?
 * In an undirected graph, edges have no direction, meaning they represent symmetric relationships between vertices.
 * In a directed graph (or digraph), edges have a direction, indicating a one-way relationship between vertices.
 *
 * */
public class UndirectedGraph {

    public static void main(String[] args) {

        adjacencyMatrixRepresentation();
        adjacencyListRepresentation();

    }

    static void adjacencyMatrixRepresentation(){

        // Create a graph with 4 vertices and no edges
        // Note that all values are initialized as 0
        int V = 4;
        int[][] mat = new int[V][V];

        // Now add edges one by one
        UndirectedAdjacencyMatrix.addEdge(mat, 0, 1);
        UndirectedAdjacencyMatrix.addEdge(mat, 0, 2);
        UndirectedAdjacencyMatrix.addEdge(mat, 1, 2);
        UndirectedAdjacencyMatrix.addEdge(mat, 2, 3);

        /* Alternatively we can also create using below
           code if we know all edges in advance

         int[][] mat = {{ 0, 1, 1, 0 },
                        { 1, 0, 1, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 0, 1, 0 } }; */

        System.out.println("Adjacency Matrix Representation");
        UndirectedAdjacencyMatrix.displayMatrix(mat);

    }

    static void adjacencyListRepresentation(){

        // Create a graph with 4 vertices and no edges
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        UndirectedAdjacencyList.addEdge(adj, 0, 1);
        UndirectedAdjacencyList.addEdge(adj, 0, 2);
        UndirectedAdjacencyList.addEdge(adj, 1, 2);
        UndirectedAdjacencyList.addEdge(adj, 2, 3);

        System.out.println("Adjacency List Representation:");
        UndirectedAdjacencyList.displayList(adj);

    }

}

/**
 * Representation of Undirected Graph as Adjacency Matrix:
 * The below figure shows an undirected graph. Initially, the entire Matrix is ​​initialized to 0. If there
 * is an edge from source to destination, we insert 1 to both cases (adjMat[destination] and adjMat[destination])
 * because we can go either way.
 * */
class UndirectedAdjacencyMatrix{

    public static void addEdge(int[][] mat, int i, int j) {
        mat[i][j] = 1;
        mat[j][i] = 1; // Since the graph is undirected
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}

/**
 * Representation of Undirected Graph as Adjacency list:
 * The below undirected graph has 3 vertices. So, an array of list will be created of size 3, where each indices
 * represent the vertices. Now, vertex 0 has two neighbours (i.e, 1 and 2). So, insert vertex 1 and 2 at indices 0
 * of array. Similarly, For vertex 1, it has two neighbour (i.e, 2 and 0) So, insert vertices 2 and 0 at indices 1
 * of array. Similarly, for vertex 2, insert its neighbours in array of list.
 * */
class UndirectedAdjacencyList{

    public static void addEdge(List<List<Integer>> list, int i, int j) {
        list.get(i).add(j);
        list.get(j).add(i); // Since the graph is undirected
    }

    public static void displayList(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ": ");
            for (int val : list.get(i)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}