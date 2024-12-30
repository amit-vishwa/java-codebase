package tutorial.dsa.algorithms.greedy;

import java.util.*;

/**
 * Refer: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
 *
 * Dijkstra's Algorithm: Finds the shortest path from a source vertex to all other vertices in a weighted graph.
 *
 * How to find Shortest Paths from Source to all Vertices using Dijkstra’s Algorithm
 * Last Updated : 06 Aug, 2024
 * Given a weighted graph and a source vertex in the graph, find the shortest paths from the source to all
 * the other vertices in the given graph.
 * Note: The given graph does not contain any negative edge.
 *
 * Algorithm :
 * - Create a set sptSet (shortest path tree set) that keeps track of vertices included in the shortest path tree,
 * i.e., whose minimum distance from the source is calculated and finalized. Initially, this set is empty.
 * - Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE .
 * Assign the distance value as 0 for the source vertex so that it is picked first.
 * - While sptSet doesn’t include all vertices
 *  -> Pick a vertex u that is not there in sptSet and has a minimum distance value.
 *  -> Include u to sptSet .
 *  -> Then update the distance value of all adjacent vertices of u .
 *      -> To update the distance values, iterate through all adjacent vertices.
 *      -> For every adjacent vertex v, if the sum of the distance value of u (from source) and weight of edge u-v ,
 *      is less than the distance value of v , then update the distance value of v .
 * Note: We use a boolean array sptSet[] to represent the set of vertices included in SPT . If a value sptSet[v] is true,
 * then vertex v is included in SPT , otherwise not. Array dist[] is used to store the shortest distance values of all vertices.
 * */
public class DijkstrasAlgorithm {

    public static void main(String[] args)
    {
        System.out.println("Dijkstra's Algorithm for shortest path using adjacency matrix:");
        getShortestPathUsingAdjacencyMatrix();
        System.out.println("\nDijkstra's Algorithm for shortest path using adjacency list:");
        getShortestPathUsingAdjacencyList();
    }

    static void getShortestPathUsingAdjacencyMatrix(){
        /* Let us create the example graph discussed above
         */
        int graph[][]
                = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        ShortestPathUsingMatrix t = new ShortestPathUsingMatrix();

        // Function call
        t.dijkstra(graph, 0);
    }

    static void getShortestPathUsingAdjacencyList() {
        int V = 9;
        ShortestPathUsingList g = new ShortestPathUsingList(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }
}

/**
 * Dijkstra’s Algorithm using Adjacency Matrix :
 *  The idea is to generate a  SPT (shortest path tree)  with a given source as a root. Maintain an Adjacency Matrix
 *  with two sets, one set contains vertices included in the shortest-path tree, other set includes vertices not yet
 *  included in the shortest-path tree.
 *  At every step of the algorithm, find a vertex that is in the other set (set not yet included) and has a minimum
 *  distance from the source.
 *
 * Time Complexity: O(V 2 )
 * Auxiliary Space: O(V)
 *
 * Notes:
 * The code calculates the shortest distance but doesn’t calculate the path information. Create a parent array, update the parent array when distance
 * is updated and use it to show the shortest path from source to different vertices.
 * The time Complexity of the implementation is O(V 2 ) . If the input graph is represented using adjacency list , it can be reduced to O(E * log V) with the
 * help of a binary heap. Please see Dijkstra’s Algorithm for Adjacency List Representation for more details.
 * Dijkstra’s algorithm doesn’t work for graphs with negative weight cycles.
 * */
class ShortestPathUsingMatrix {
    // A utility function to find the vertex with minimum
    // distance value, from the set of vertices not yet
    // included in shortest path tree
    static final int V = 9;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance
    // array
    void printSolution(int dist[])
    {
        System.out.println(
                "Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements Dijkstra's single source
    // shortest path algorithm for a graph represented using
    // adjacency matrix representation
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; // The output array.
        // dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        Boolean sptSet[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[]
        // as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist);
    }
}

/**
 * Dijkstra’s Algorithm using Adjacency List in O(E logV):
 *  For Dijkstra’s algorithm, it is always recommended to use  Heap  (or  priority queue  ) as the required operations (extract minimum and decrease key) match with the speciality of the heap (or priority queue). However, the problem is, that priority_queue doesn’t support the decrease key. To resolve this problem, do not update a key, but insert one more copy of it. So we allow multiple instances of the same vertex in the priority queue. This approach doesn’t require decreasing key operations and has below important properties.
 *  Whenever the distance of a vertex is reduced, we add one more instance of a vertex in priority_queue. Even if there are multiple instances, we only consider the instance with minimum distance and ignore other instances.
 *  The time complexity remains  O(E * LogV)  as there will be at most O(E) vertices in the priority queue and O(logE) is the same as O(logV)
 *
 *  Time Complexity: O(E * logV), Where E is the number of edges and V is the number of vertices.
 *  Auxiliary Space: O(V)
 * */
class ShortestPathUsingList {
    private int V;
    private List<List<iPair>> adj;
    ShortestPathUsingList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (iPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new iPair(dist[v.first], v.first));
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}