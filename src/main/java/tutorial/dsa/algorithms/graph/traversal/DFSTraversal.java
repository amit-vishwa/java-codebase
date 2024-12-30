package tutorial.dsa.algorithms.graph.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 *
 * Depth First Search (or DFS) for a graph is similar to Depth First Traversal of a tree. Like trees, we traverse all adjacent
 * vertices one by one. When we traverse an adjacent vertex, we completely finish the traversal of all vertices reachable through
 * that adjacent vertex. After we finish traversing one adjacent vertex and its reachable vertices, we move to the next adjacent
 * vertex and repeat the process. This is similar to a tree, where we first completely traverse the left subtree and then move to
 * the right subtree. The key difference is that, unlike trees, graphs may contain cycles (a node may be visited more than once).
 * To avoid processing a node multiple times, we use a boolean visited array.
 *
 * DFS from a Given Source of Undirected Graph:
 * The algorithm starts from a given source and explores all reachable vertices from the given source. It is similar to Preorder
 * Tree Traversal where we visit the root, then recur for its children. In a graph, there maybe loops. So we use an extra visited
 * array to make sure that we do not process a vertex again.
 *
 * DFS for Complete Traversal of Disconnected Undirected Graph
 * The above implementation takes a source as an input and prints only those vertices that are reachable from the source and would
 * not print all vertices in case of disconnected graph. Let us now talk about the algorithm that prints all vertices without any
 * source and the graph maybe disconnected.
 * The idea is simple, instead of calling DFS for a single vertex, we call the above implemented DFS for all all non-visited
 * vertices one by one.
 *
 * Time complexity: O(V + E). Note that the time complexity is same here because we visit every vertex at most once and every
 * edge is traversed at most once (in directed) and twice in undirected.
 * Auxiliary Space: O(V + E), since an extra visited array of size V is required, And stack size for recursive calls to DFSRec function.
 * */
public class DFSTraversal {
    // Function to add an edge to the adjacency list
    static void addEdge(List<List<Integer>> adj, int s,
                        int t){
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    // Recursive function for DFS traversal
    static void DFSRec(List<List<Integer> > adj,
                       boolean[] visited, int s){
        visited[s] = true;
        System.out.print(s + " ");

        // Recursively visit all adjacent vertices that are
        // not visited yet
        for (int i : adj.get(s)) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }
    // Main DFS function to perform DFS for the entire graph
    static void DFS(List<List<Integer> > adj, int V){
        boolean[] visited = new boolean[V];

        // Loop through all vertices to handle disconnected
        // graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }
    public static void main(String[] args){
        int V = 6;

        // Create an adjacency list for the graph
        List<List<Integer> > adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges
                = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            addEdge(adj, edge[0], edge[1]);
        }

        System.out.println("Complete DFS of the graph:");
        DFS(adj, V);
    }
}