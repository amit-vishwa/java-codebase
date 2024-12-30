package tutorial.dsa.algorithms.graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Refer: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 *
 * Breadth First Search (BFS) is a fundamental graph traversal algorithm. It begins with a node, then first traverses all its
 * adjacent. Once all adjacent are visited, then their adjacent are traversed. This is different from DFS in a way that closest
 * vertices are visited before others. We mainly traverse vertices level by level. A lot of popular graph algorithms like
 * Dijkstra’s shortest path, Kahn’s Algorithm, and Prim’s algorithm are based on BFS. BFS itself can be used to detect cycle in
 * a directed and undirected graph, find the shortest path in an unweighted graph and many more problems.
 *
 * BFS from a Given Source:
 * The algorithm starts from a given source and explores all reachable vertices from the given source. It is similar to the Breadth-First Traversal of a tree. Like tree, we begin with the given source (in tree, we begin with root) and traverse vertices level by level using a queue data structure. The only catch here is that, unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array.
 *
 * Initialization: Enqueue the given source vertex into a queue and mark it as visited.
 *
 * Exploration: While the queue is not empty:
 * Dequeue a node from the queue and visit it (e.g., print its value).
 * For each unvisited neighbor of the dequeued node:
 * Enqueue the neighbor into the queue.
 * Mark the neighbor as visited.
 *
 * Termination: Repeat step 2 until the queue is empty.
 * This algorithm ensures that all nodes in the graph are visited in a breadth-first manner, starting from the starting node.
 *
 * BFS of the whole Graph which Maybe Disconnected
 * The above implementation takes a source as an input and prints only those vertices that are reachable from the source and
 * would not print all vertices in case of disconnected graph. Let us now talk about the algorithm that prints all vertices
 * without any source and the graph maybe disconnected.
 * The idea is simple, instead of calling BFS for a single vertex, we call the above implemented BFS for all all non-visited
 * vertices one by one.
 *
 * Complexity Analysis of Breadth-First Search (BFS) Algorithm:
 * 1.Time Complexity of BFS Algorithm: O(V + E)
 * BFS explores all the vertices and edges in the graph. In the worst case, it visits every vertex and edge once. Therefore,
 * the time complexity of BFS is O(V + E), where V and E are the number of vertices and edges in the given graph.
 * 2.Auxiliary Space of BFS Algorithm: O(V)
 * BFS uses a queue to keep track of the vertices that need to be visited. In the worst case, the queue can contain all the
 * vertices in the graph. Therefore, the space complexity of BFS is O(V).
 * */
public class BFSTraversal {

    // Perform BFS for the entire graph which maybe
    // disconnected
    public static void bfsDisconnected(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()]; // Not visited

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }

    // BFS from given source s
    public static void bfs(List<List<Integer>> adj,
                           int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        // Mark the source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        // Iterate over the queue
        while (!q.isEmpty()) {
            int curr = q.poll(); // Dequeue a vertex
            System.out.print(curr + " ");

            // Get all adjacent vertices of curr
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true; // Mark as visited
                    q.add(x); // Enqueue it
                }
            }
        }
    }

    // Function to add an edge to the graph
    public static void addEdge(List<List<Integer>> adj,
                               int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph
    }

    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>(V);

        // Initialize adjacency lists
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        // Perform BFS traversal for the entire graph
        bfsDisconnected(adj);
    }
}