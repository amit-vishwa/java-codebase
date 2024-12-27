package tutorial.dsa.datastructures.graphs.weighted;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Refer: https://www.geeksforgeeks.org/adjacency-matrix/
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
public class WeightedUndirectedGraph {

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
        UndirectedAdjacencyMatrix.addEdge(mat, 0, 1, 5);
        UndirectedAdjacencyMatrix.addEdge(mat, 1, 2, 7);
        UndirectedAdjacencyMatrix.addEdge(mat, 1, 3, 10);
        UndirectedAdjacencyMatrix.addEdge(mat, 2, 3, 3);
        UndirectedAdjacencyMatrix.addEdge(mat, 3, 4, 6);

        /* Alternatively we can also create using below
           code if we know all edges in advance

         int[][] mat = {{ 0, 5, 1, 0, 0 },
                        { 5, 0, 7, 10, 0 },
                        { 0, 7, 0, 3, 0 },
                        { 0, 10, 3, 0, 6 },
                        { 0, 0, 0, 6, 0 } }; */

        System.out.println("Adjacency Matrix Representation");
        UndirectedAdjacencyMatrix.displayMatrix(mat);

    }

    static void adjacencyListRepresentation(){

        // Create a graph with 3 vertices and 3 edges
        int V = 3;
        List<List<SimpleEntry<Integer, Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        UndirectedAdjacencyList.addEdge(adj, 1, 0, 4);
        UndirectedAdjacencyList.addEdge(adj, 1, 2, 3);
        UndirectedAdjacencyList.addEdge(adj, 2, 0, 1);

        System.out.println("Adjacency List Representation:");
        UndirectedAdjacencyList.displayAdjList(adj);

    }

}

/**
 * Refer: https://www.geeksforgeeks.org/adjacency-matrix/#2-adjacency-matrix-for-undirected-and-weighted-graph
 *
 * 2. Adjacency Matrix for Undirected and Weighted graph:
 * Consider an Undirected and Weighted graph G with 2 vertices and 5 edges. For the graph G, the adjacency
 * matrix would look like:
 *      0   1
 * 0    INF 7
 * 1    7   INF
 * Here's how to interpret the matrix:
 * A[i][j] = INF, then there is no edge between vertex i and j
 * A[i][j] = w, then there is an edge between vertex i and j having weight = w.
 * */
class UndirectedAdjacencyMatrix{

    public static void addEdge(int[][] mat, int i, int j, int w) {
        mat[i][j] = w;
        mat[j][i] = w; // Since the graph is undirected
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
 *
 * Refer: https://www.geeksforgeeks.org/adjacency-list-meaning-definition-in-dsa/#4-adjacency-list-for-undirected-and-weighted-graph
 *
 * 4. Adjacency List for Undirected and Weighted graph:
 * Consider an Undirected and Weighted graph G with 3 vertices and 3 edges. For the graph G, the adjacency list would look like
 *
 * */
class UndirectedAdjacencyList{

    static void addEdge(List<List<SimpleEntry<Integer, Integer>>> adj, int u, int v, int w) {
        adj.get(u).add(new SimpleEntry<>(v, w));
        adj.get(v).add(new SimpleEntry<>(u, w));
    }

    static void displayAdjList(List<List<SimpleEntry<Integer, Integer>>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (SimpleEntry<Integer, Integer> j : adj.get(i)) {
                System.out.print("{" + j.getKey() + ", " + j.getValue() + "} ");
            }
            System.out.println();
        }
    }

}