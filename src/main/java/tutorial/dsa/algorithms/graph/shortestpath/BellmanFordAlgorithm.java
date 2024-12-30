package tutorial.dsa.algorithms.graph.shortestpath;

import java.util.Arrays;

/**
 * Refer: https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
 *
 * Given a weighted graph with V vertices and E edges, and a source vertex src, find the shortest path from the source vertex to
 * all vertices in the given graph. If a vertex cannot be reached from source vertex, mark its distance as 108.
 * Note: If a graph contains negative weight cycle, return -1.
 *
 * Limitation of Dijkstra’s Algorithm:
 * Since, we need to find the single source shortest path, we might initially think of using Dijkstra’s algorithm. However,
 * Dijkstra is not suitable when the graph consists of negative edges. The reason is, it doesn’t revisit those nodes which have
 * already been marked as visited. If a shorter path exists through a longer route with negative edges, Dijkstra’s algorithm will
 * fail to handle it.
 *
 * Bellman-Ford Algorithm – O(V*E) Time and O(V) Space
 * Bellman-Ford is a single source shortest path algorithm. It effectively works in the cases of negative edges and is able to
 * detect negative cycles as well. It works on the principle of relaxation of the edges.
 *
 * Principle of Relaxation of Edges
 * Relaxation means updating the shortest distance to a node if a shorter path is found through another node. For an edge (u, v)
 * with weight w:
 * If going through u gives a shorter path to v from the source node (i.e., distance[v] > distance[u] + w), we update the
 * distance[v] as distance[u] + w.
 * In the bellman-ford algorithm, this process is repeated (V – 1) times for all the edges.
 *
 * Time Complexity:
 * Best Case: O(E), when distance array after 1st and 2nd relaxation are same , we can simply stop further processing.
 * Average Case: O(V*E)
 * Worst Case: O(V*E)
 * */
public class BellmanFordAlgorithm {

    static int[] bellmanFord(int V, int[][] edges, int src) {

        // Initially distance from source to all other vertices
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {

                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};

                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = new int[][] {
                {1, 3, 2},
                {4, 3, -1},
                {2, 4, 1},
                {1, 2, 1},
                {0, 1, 5}
        };

        int src = 0;
        int[] ans = bellmanFord(V, edges, src);
        for (int dist : ans)
            System.out.print(dist + " ");
    }

}