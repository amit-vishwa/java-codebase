package tutorial.dsa.datastructures.graphs.weighted;

import java.util.AbstractMap;
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
public class WeightedDirectedGraph {

    public static void main(String[] args) {

        adjacencyMatrixRepresentation();
        adjacencyListRepresentation();

    }

    static void adjacencyMatrixRepresentation(){

        // Create a graph with 4 vertices and no edges
        // Note that all values are initialized as 0
        int V = 5;
        int[][] mat = new int[V][V];

        // Now add edges one by one
        DirectedAdjacencyMatrix.addEdge(mat, 0, 1, 5);
        DirectedAdjacencyMatrix.addEdge(mat, 1, 2, 7);
        DirectedAdjacencyMatrix.addEdge(mat, 1, 3, 10);
        DirectedAdjacencyMatrix.addEdge(mat, 2, 3, 3);
        DirectedAdjacencyMatrix.addEdge(mat, 3, 4, 6);

        /* Alternatively we can also create using below
           code if we know all edges in advance

         int[][] mat = {{ 0, 5, 0, 0, 0 },
                        { 0, 0, 7, 10, 0 },
                        { 0, 0, 0, 3, 0 },
                        { 0, 0, 0, 0, 6 },
                        { 0, 0, 0, 0, 0 } }; */

        System.out.println("Adjacency Matrix Representation");
        DirectedAdjacencyMatrix.displayMatrix(mat);

    }

    static void adjacencyListRepresentation(){

        // Create a graph with 3 vertices and 3 edges
        int V = 3;
        List<List<AbstractMap.SimpleEntry<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        DirectedAdjacencyList.addEdge(adj, 1, 0, 4);
        DirectedAdjacencyList.addEdge(adj, 1, 2, 3);
        DirectedAdjacencyList.addEdge(adj, 2, 0, 1);

        System.out.println("Adjacency List Representation:");
        DirectedAdjacencyList.displayAdjList(adj);

    }

}

/**
 * Refer: https://www.geeksforgeeks.org/adjacency-matrix/#2-adjacency-matrix-for-undirected-and-weighted-graph
 * Similar to undirected weighted adjacency matrix, only remove vice versa condition
 * */
class DirectedAdjacencyMatrix{

    public static void addEdge(int[][] mat, int i, int j, int w) {
        mat[i][j] = w;
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
 * Refer: https://www.geeksforgeeks.org/adjacency-list-meaning-definition-in-dsa/#3-adjacency-list-for-directed-and-weighted-graph
 * Similar to undirected weighted adjacency list, only remove vice versa condition
 * */
class DirectedAdjacencyList{

    static void addEdge(List<List<AbstractMap.SimpleEntry<Integer, Integer>>> adj, int u, int v, int w) {
        adj.get(u).add(new AbstractMap.SimpleEntry<>(v, w));
    }

    static void displayAdjList(List<List<AbstractMap.SimpleEntry<Integer, Integer>>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (AbstractMap.SimpleEntry<Integer, Integer> j : adj.get(i)) {
                System.out.print("{" + j.getKey() + ", " + j.getValue() + "} ");
            }
            System.out.println();
        }
    }

}